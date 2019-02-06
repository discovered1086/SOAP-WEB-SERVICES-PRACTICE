package com.credentialservice.business;



import com.credentialservice.model.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by kingshuk on 7/22/17.
 */
//We'll mark this interface with the JAX-WS annotation so that it becomes
//An end point for the web service
@WebService(name="CredentialsServicePortType")
public interface CredentialManager {

    //The @WebParam and @WebResults annotations are not required for the operation but it'll make the parameters appear
    //in the WSDL file
    //@WebMethod
    @WebResult(name="saveResult")
    DDLCredentialResponse saveCredentials(@WebParam(name="saveCredentialRequest") SaveOrUpdateCredentialRequest credentialRequest);

    //@WebMethod
    @WebResult(name = "credentialList")
    GetCredentialsListResponse getCredentialsListForView(
            @WebParam(name="searchString")GetCredentialsListOrDeleteCredentialRequest searchStringRequest);


    //@WebMethod
    @WebResult(name="singleCredentialInformation") GetCredentialForStorageResponse getCredentialForStorageInSession(
            @WebParam(name="credentialsListForStorage") GetCredentialForStorageRequest credentialsList);

    //@WebMethod
    @WebResult(name="updateResult")
    DDLCredentialResponse updateCredentials(@WebParam(name="credentials")SaveOrUpdateCredentialRequest credentialsUpdateRequest);

    //@WebMethod
    @WebResult(name="deleteResult")
    DDLCredentialResponse deleteCredentials(@WebParam(name="accountId")GetCredentialsListOrDeleteCredentialRequest accountId);
}
