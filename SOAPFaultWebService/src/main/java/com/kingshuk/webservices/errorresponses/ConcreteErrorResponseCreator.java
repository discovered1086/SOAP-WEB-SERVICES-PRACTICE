package com.kingshuk.webservices.errorresponses;

import java.util.Optional;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcreteErrorResponseCreator {

	@Autowired
	private GenericErrorResponseMarshaller genericErrorResponseMarshaller;

	public Optional<String> changeMessage(SoapMessage message, String currentEnvelope)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		BindingMessageInfo output = message.getExchange().getBindingOperationInfo().getOutput();

		String localPart = output.getMessageParts().get(0).getTypeQName().getLocalPart();

		String outputClassName = output.getMessageParts().get(0).getTypeClass().getName();
		
		System.out.println("The response class name is " + outputClassName);

		return buildFinalMessage(localPart, currentEnvelope, outputClassName);

	}

	private Optional<String> buildFinalMessage(String localPart, String currentEnvelope, String outputClassName) {
				
		Optional<String> finalMessage = Optional.empty();

		try {

			Optional<String> xmlStringOptional = genericErrorResponseMarshaller.getXMLMessage(outputClassName);

			if (xmlStringOptional.isPresent()) {
				
				String xmlString = xmlStringOptional.get();

				System.out.println(xmlString);

				String newString = xmlString.substring(xmlString.indexOf("<" + localPart));

				System.out.println(newString);

				String soapBody = currentEnvelope.substring(
						currentEnvelope.indexOf("<soap:Body>") + "<soap:Body>".length(),
						currentEnvelope.indexOf("</soap:Body>"));

				finalMessage = Optional.ofNullable(currentEnvelope.replace(soapBody, newString));

				System.out.println(soapBody);

			} else {
				finalMessage = Optional.ofNullable(currentEnvelope);
			}

		} catch (Exception e) {
			e.printStackTrace();
			finalMessage = Optional.empty();
			
		}

		return finalMessage;
	}

}
