package com.kingshuk.webservices.errorresponses;

import java.io.StringWriter;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GenericErrorResponseMarshaller {

	private static Logger logger = Logger.getLogger(GenericErrorResponseMarshaller.class);

	@SuppressWarnings("unchecked")

	public <T> Optional<String> getXMLMessage(String className) {

		PreEndpointErrorResponses newInstance = null;

		try {
			Class<T> class1 = (Class<T>) Class.forName(PreEndpointErrorResponses.class.getPackage().getName()
					+ className.substring(className.lastIndexOf('.')));

			if (class1.getSuperclass().equals(PreEndpointErrorResponses.class)) {
				newInstance = (PreEndpointErrorResponses) class1.newInstance();

				newInstance.setErrorCode("50589");
				newInstance.setErrorMessage("A schema Validation error occurred");
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			logger.log(null, "context", "error occurred while performing operation", e);
		}


		return getParsedMessage(newInstance);
	}

	private <T extends PreEndpointErrorResponses> Optional<String> getParsedMessage(T errorResponseObject) {
		
		Optional<String> updatedMessage =  Optional.empty();

		JAXBContext context;
		try {

			context = JAXBContext.newInstance(errorResponseObject.getClass());

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			
			String nodeName =  errorResponseObject.getClass().getSimpleName();
			
			String modifiedNodeName =  nodeName.replace(nodeName.charAt(0), Character.toLowerCase(nodeName.charAt(0)));
			
			QName rootName = new QName(errorResponseObject.getNameSpace(), modifiedNodeName, "dnd");
			 @SuppressWarnings("unchecked")
			JAXBElement<T> root = new JAXBElement<T>(rootName, (Class<T>) errorResponseObject.getClass(), errorResponseObject);
			
			//marshaller.marshal(errorResponseObject, sw);
			 
			 marshaller.marshal(root, sw);
			
			updatedMessage = Optional.ofNullable(sw.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return updatedMessage;
	}

}
