package com.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by kingshuk on 6/17/17.
 */
@WebService
public class SayHello {

    @WebMethod
    public String helloWorld(){
        return "Hello from Kingshuk's side";
    }
}
