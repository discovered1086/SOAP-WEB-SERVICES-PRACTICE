package com.kingshuk.webservices.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kingshuk.webservices.EmployeeServiceImpl;
import com.kingshuk.webservices.MySchemaValidationInterceptor;

@Configuration
public class WebServiceConfiguration {

	
	@Bean
	public Endpoint endpoint(Bus bus) {
		EndpointImpl endpoint = new EndpointImpl(bus, new EmployeeServiceImpl());
		endpoint.getOutFaultInterceptors().add(new MySchemaValidationInterceptor());
		
		endpoint.publish("/services/soapFaultWebService");
		
		return endpoint;
	}
	
	@Bean
	public EmployeeServiceImpl getEndpoint() {
		return new EmployeeServiceImpl();
	}

}
