package com.kingshuk.webservices;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import com.kingshuk.webservices.errorresponses.InterceptorErrorresponseBuilder;


public class MySchemaValidationInterceptor extends AbstractSoapInterceptor {
	
	
	private static final InterceptorErrorresponseBuilder errorresponseBuilder = new InterceptorErrorresponseBuilder();

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
        	errorresponseBuilder.getCustomErrorResponse(message);
       }
		
	}

	

}
