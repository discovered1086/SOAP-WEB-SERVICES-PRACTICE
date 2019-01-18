package com.kingshuk.webservices.errorresponses;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcreteErrorResponseCreator {
	

	@Autowired
	private GenericErrorResponseMarshaller genericErrorResponseMarshaller;
	
	public String changeMessage(SoapMessage message, String currentEnvelope)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		BindingMessageInfo output = message.getExchange().getBindingOperationInfo().getOutput();

		String localPart = output.getMessageParts().get(0).getTypeQName().getLocalPart();

		String outputClassName = output.getMessageParts().get(0).getTypeClass().getName();

		String buildFinalMessage = buildFinalMessage(localPart, currentEnvelope, outputClassName);

		System.out.println("The response class name is " + outputClassName);

		return buildFinalMessage;
	}
	
	private String buildFinalMessage(String localPart, String currentEnvelope, String outputClassName) {
		String finalMessage ="" ;
		
			try {
				
				String xmlString = genericErrorResponseMarshaller.getXMLMessage(outputClassName);
				
				
				System.out.println(xmlString);

				String newString = xmlString.substring(xmlString.indexOf("<" + localPart));

				System.out.println(newString);

				String soapBody = currentEnvelope.substring(
						currentEnvelope.indexOf("<soap:Body>") + "<soap:Body>".length(),
						currentEnvelope.indexOf("</soap:Body>"));

				finalMessage = currentEnvelope.replace(soapBody, newString);

				System.out.println(soapBody);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return finalMessage;
	}

}
