package com.kingshuk.webservices.errorresponses;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

@Component
public class GenericErrorResponseMarshaller<T extends PreEndpointErrorResponses> {

@SuppressWarnings("unchecked")
public String getXMLMessage(String localPartName) {
		
	GenericErrorResponseCreator<T> genericErrorResponseCreator=null;
	
	Class<T> class1 = null;
		
		if("employeeResponse".equals(localPartName)) {
			
			class1 = (Class<T>) EmployeeErrorResponse.class;
			genericErrorResponseCreator =() ->{
				EmployeeErrorResponse response = new EmployeeErrorResponse();

				response.setErrorCode("50589");
				response.setErrorMessage("A schema Validation error occured");
				return (T) response;
			};
		}

		
		return getParsedMessage(class1, genericErrorResponseCreator);
	}

private String getParsedMessage(Class<T> class1, GenericErrorResponseCreator<T> genericErrorResponseCreator) {
	
	String updatedMessage="";
	JAXBContext context;
	try {
		context = JAXBContext.newInstance(class1.getName().getClass());
		
		Marshaller marshaller = context.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		StringWriter sw = new StringWriter();
		marshaller.marshal(genericErrorResponseCreator.getErrorResponse(), sw);
		 updatedMessage= sw.toString();
	} catch (JAXBException e) {
		e.printStackTrace();
	}
	
	return updatedMessage;
}

}
