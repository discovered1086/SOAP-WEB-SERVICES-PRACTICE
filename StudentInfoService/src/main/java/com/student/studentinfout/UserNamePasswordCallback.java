package com.student.studentinfout;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kingshuk on 9/10/17.
 * This is the callback handler class
 * This class acts as a communication ground for the application
 * and the underlying web services stack which is CXF in this case
 *
 * This is the 1st step of setting up the user name token profile
 */
public class UserNamePasswordCallback implements CallbackHandler{
    /*
        Creating the map just for simplicity but in real time passwords will be extracted
        from database or active directory
     */
    private Map<String,String> passwordsMap= new TreeMap();

    public UserNamePasswordCallback() {
       passwordsMap.put("rishi2616","Iofdtiger#16");
       passwordsMap.put("cxf","cxf");
    }

    /**
     * Once the SOAP message comes in with the user name
     * and password in the header, CXF will call this method by pulling
     * the user ID from this SOAP header
     * If the user ID and password are correct, it'll forward the request to
     * the correct web services end point. otherwise it'll send back and authentication
     * exception to the client
     * @param callbacks
     * @throws IOException
     * @throws UnsupportedCallbackException
     */
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("The handler method has been called for password call back");
        System.out.println("Callbacks: "+callbacks);
        for (Object object:callbacks) {
            WSPasswordCallback passwordCallback=(WSPasswordCallback)object;

            //In this line basically we're extracting the password from the database or active directory
            //(Implemented here as a map for simplicity) for the user ID that has come in
            //Basic authentication
            String password=passwordsMap.get(passwordCallback.getIdentifier());

            if(password!=null) {   //This means the password is correct
                passwordCallback.setPassword(password);
                return;
            }

        }
    }
}
