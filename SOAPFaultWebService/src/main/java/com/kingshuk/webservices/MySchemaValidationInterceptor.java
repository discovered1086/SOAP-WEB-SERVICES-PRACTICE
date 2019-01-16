package com.kingshuk.webservices;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.BindingMessageInfo;

import com.kingshuk.webservices.errorresponses.EmployeeResponse;

public class MySchemaValidationInterceptor extends AbstractSoapInterceptor {

	public MySchemaValidationInterceptor() {
		super(Phase.PRE_STREAM);
		// addBefore(DocLiteralInInterceptor.class.getName());
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		
		boolean isOutbound = false;
        isOutbound = message == message.getExchange().getOutMessage()
                || message == message.getExchange().getOutFaultMessage();
        
        
        if(isOutbound) {
		OutputStream os = message.getContent(OutputStream.class);
		
		CachedOutputStream cs = new CachedOutputStream();
        message.setContent(OutputStream.class, cs);

        message.getInterceptorChain().doIntercept(message);
        
        //org.apache.cxf.message.Message.RESPONSE_CODE
        
        message.put(MessageImpl.RESPONSE_CODE, 200);
        
        try {
			cs.flush();
			
			IOUtils.closeQuietly(cs);
			
			CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
			
			String currentEnvelope = IOUtils.toString(csnew.getInputStream(), "UTF-8");
			
			System.out.println(currentEnvelope);
			
			String modifiedEnvelopeString= changeMessage(message,currentEnvelope);
			
			InputStream replaceInStream = IOUtils.toInputStream(modifiedEnvelopeString, "UTF-8");

            IOUtils.copy(replaceInStream, os);
            replaceInStream.close();
            IOUtils.closeQuietly(replaceInStream);
            
           

            os.flush();
            message.setContent(OutputStream.class, os);
            

            IOUtils.closeQuietly(os);
		} catch (Exception e) {
			e.printStackTrace();
		}
       }
		
	}

	private String changeMessage(SoapMessage message, String currentEnvelope)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		BindingMessageInfo output = message.getExchange().getBindingOperationInfo().getOutput();

		String localPart = output.getMessageParts().get(0).getTypeQName().getLocalPart();

		String outputClassName = output.getMessageParts().get(0).getTypeClass().getName();

		String finalMessage = "";

		if (outputClassName.contains("EmployeeResponse")) {

			EmployeeResponse response = new EmployeeResponse();

			response.setErrorCode("50589");
			response.setErrorMessage("A schema Validation error occured");

			try {
				JAXBContext context = JAXBContext.newInstance(EmployeeResponse.class);

				Marshaller marshaller = context.createMarshaller();

				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				StringWriter sw = new StringWriter();
				marshaller.marshal(response, sw);
				String xmlString = sw.toString();

				System.out.println(xmlString);

				String newString = xmlString.substring(xmlString.indexOf("<" + localPart));

				System.out.println(newString);

				String soapBody = currentEnvelope.substring(
						currentEnvelope.indexOf("<soap:Body>") + "<soap:Body>".length(),
						currentEnvelope.indexOf("</soap:Body>"));

				finalMessage = currentEnvelope.replace(soapBody, newString);

				System.out.println(soapBody);

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("The response class name is " + outputClassName);

		return finalMessage;
	}

}
