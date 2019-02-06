package com.credentialservice.business;


import com.credentialservice.model.Credentials;
import com.credentialservice.model.NotificationRequest;
import com.credentialservice.model.NotificationResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by kingshuk on 7/22/17.
 */
//We'll mark this interface with the JAX-WS annotation so that it becomes
//An end point for the web service
@WebService(name="NotificationServicePortType")
public interface NotificationSender {

    //@WebMethod
    @WebResult(name="outputMessage")
    NotificationResponse sendEmail(
            @WebParam(name="notificationRequest")NotificationRequest notificationRequest);
}
