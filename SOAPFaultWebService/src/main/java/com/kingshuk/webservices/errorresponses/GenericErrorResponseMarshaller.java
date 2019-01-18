package com.kingshuk.webservices.errorresponses;

import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GenericErrorResponseMarshaller {

	

	@SuppressWarnings("unchecked")
	public <T> String getXMLMessage(String className) {
		
		
		
		PreEndpointErrorResponses newInstance = null;
		
		try {
			Class<T> class1= (Class<T>)Class.forName(PreEndpointErrorResponses.class.getPackage().getName()+className.substring(className.lastIndexOf(".")));
			
			if(class1.getSuperclass().equals(PreEndpointErrorResponses.class)) {
				newInstance = (PreEndpointErrorResponses)class1.newInstance();
				
				newInstance.setErrorCode("50589");
				newInstance.setErrorMessage("A schema Validation error occurred");
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		

		/*GenericErrorResponseCreator<Type> genericErrorResponseCreator = null;

		genericErrorResponseCreator = () -> {

			T newInstance = null;

			try {
				newInstance = class1.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

			newInstance.setErrorCode("50589");
			newInstance.setErrorMessage("A schema Validation error occured");
			return newInstance;
		};*/

		return getParsedMessage(newInstance);
	}

	private <T extends PreEndpointErrorResponses> String getParsedMessage(T errorResponseObject) {

		String updatedMessage = "";
		JAXBContext context;
		try {

			context = JAXBContext.newInstance(errorResponseObject.getClass());

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(errorResponseObject, sw);
			updatedMessage = sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return updatedMessage;
	}

}
