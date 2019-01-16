package com.kingshuk.webservices;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.wsdl.interceptors.DocLiteralInInterceptor;
import org.xml.sax.SAXException;

public class MyInterceptor extends AbstractSoapInterceptor{
	
	//@Autowired
	//private EmployeeServiceImpl employeeServiceImpl;
	

	public MyInterceptor() {
		super(Phase.UNMARSHAL);
		addBefore(DocLiteralInInterceptor.class.getName());
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		
		try {
			System.out.println("It reached my custom interceptor");
			
			//Exchange exchange = message.getExchange();
			
			//Service service = ServiceModelUtil.getService(exchange);
			JAXBContext context = JAXBContext.newInstance(Object.class);

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			Schema schema = sf.newSchema(new File("src/main/resources/MyWebServices.xsd"));
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			unmarshaller.setSchema(schema);
		
			        //unmarshaller.setEventHandler(new EmployeeValidationEventHandler());
			
			


			/*EmployeeServiceImpl employeeServiceImpl= new EmployeeServiceImpl();
			
			EmployeeRequest employeeRequest= new EmployeeRequest();
			employeeServiceImpl.getEmployeeOperation(employeeRequest);*/
			
		}catch(Fault fault) {
			System.out.println("Caught the exception from the other interceptor");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
