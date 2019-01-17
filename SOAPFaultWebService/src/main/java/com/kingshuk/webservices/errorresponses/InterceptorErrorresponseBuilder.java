package com.kingshuk.webservices.errorresponses;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.MessageImpl;


public class InterceptorErrorresponseBuilder {
	
	public void getCustomErrorResponse(SoapMessage message) {
OutputStream os = message.getContent(OutputStream.class);
		
		CachedOutputStream cs = new CachedOutputStream();
        message.setContent(OutputStream.class, cs);

        message.getInterceptorChain().doIntercept(message);
        
        //org.apache.cxf.message.Message.RESPONSE_CODE
        
        message.put(MessageImpl.RESPONSE_CODE, 200);
        
        try {
			cs.flush();
			
			IOUtils.closeQuietly(cs);
			
			CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
			
			String currentEnvelope = IOUtils.toString(csnew.getInputStream(), "UTF-8");
			
			System.out.println(currentEnvelope);
			
			String modifiedEnvelopeString= ConcreteErrorResponseCreator.changeMessage(message,currentEnvelope);
			
			InputStream replaceInStream = IOUtils.toInputStream(modifiedEnvelopeString, "UTF-8");

            IOUtils.copy(replaceInStream, os);
            replaceInStream.close();
            IOUtils.closeQuietly(replaceInStream);
            
           

            os.flush();
            message.setContent(OutputStream.class, os);
            

            IOUtils.closeQuietly(os);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
       
	}

}
