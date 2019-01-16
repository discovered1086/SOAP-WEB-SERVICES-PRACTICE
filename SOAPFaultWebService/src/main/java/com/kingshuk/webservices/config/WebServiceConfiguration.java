package com.kingshuk.webservices.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kingshuk.webservices.EmployeeServiceImpl;
import com.kingshuk.webservices.MySchemaValidationInterceptor;

@Configuration
public class WebServiceConfiguration {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new EmployeeServiceImpl());
		//endpoint.getHandlers().add(new SOAPValidationHandler());
		//endpoint.getHandlers().add(new MyValidationHandler());
		endpoint.getOutFaultInterceptors().add(new MySchemaValidationInterceptor());
		
		endpoint.publish("/services/soapFaultWebService");
		
		return endpoint;
	}
	
	@Bean
	public EmployeeServiceImpl getEndpoint() {
		return new EmployeeServiceImpl();
	}

}
