package com.studentinfoservice.client;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kingshuk on 11/16/17.
 * This class handles the password callback at the client side. When a request is made by the client for the endpoint,
 * The end point checks for interceptors, it finds one in our case and the interceptors properties tells it to use this class
 * for obtaining the password at run time.
 *
 * This class extends CallbackHandler so that it can handle call backs.Here we just have one callback for password. But there could be
 * scenarios where multiple callbacks are put into one array and shared with this class.
 */
public class StudentInfoPasswordCallBack implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Object object : callbacks){
            WSPasswordCallback callback=(WSPasswordCallback)object;
            if("rishi2616".equals(callback.getIdentifier())){
                callback.setPassword(readPassword());
                //callback.setPassword("Iofdtiger#16");
                break;
            }
        }
    }

    private String readPassword() throws IOException {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Please enter your password: ");
        return scanner.next();
    }
}
