package com.kingshuk.webservices.errorresponses;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.service.model.BindingMessageInfo;

public class ConcreteErrorResponseCreator {
	
	public static String changeMessage(SoapMessage message, String currentEnvelope)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		BindingMessageInfo output = message.getExchange().getBindingOperationInfo().getOutput();

		String localPart = output.getMessageParts().get(0).getTypeQName().getLocalPart();

		String outputClassName = output.getMessageParts().get(0).getTypeClass().getName();

		String buildFinalMessage = buildFinalMessage(localPart, currentEnvelope);

		System.out.println("The response class name is " + outputClassName);

		return buildFinalMessage;
	}
	
	private static String buildFinalMessage(String localPart, String currentEnvelope) {
		String finalMessage ="" ;
		
		if (localPart.contains("employeeResponse")) {

			//EmployeeErrorResponseCrator creator =  new EmployeeErrorResponseCrator();
			
			GenericErrorResponseCreator<EmployeeErrorResponse> genericErrorResponseCreator
			=() ->{
				EmployeeErrorResponse response = new EmployeeErrorResponse();

				response.setErrorCode("50589");
				response.setErrorMessage("A schema Validation error occured");
				return response;
			};
			
			try {
				JAXBContext context = JAXBContext.newInstance(EmployeeErrorResponse.class);

				Marshaller marshaller = context.createMarshaller();

				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				StringWriter sw = new StringWriter();
				marshaller.marshal(genericErrorResponseCreator.getErrorResponse(), sw);
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
		
		return finalMessage;
	}

}
