package com.kingshuk.business;


import com.credentialservice.business.*;

import javax.xml.ws.soap.SOAPFaultException;
import java.lang.Exception;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by kingshuk on 7/23/17.
 */
public class CredentialServiceBusinessDelegateImpl implements CredentialServiceBusinessDelegate {
    private CredentialManagerService credentialsService = null;
    private CredentialsServicePortType servicePortType = null;

    private NotificationSenderService notificationSenderService = null;
    private NotificationServicePortType notificationServicePortType = null;


    public CredentialServiceBusinessDelegateImpl() {

        try {
            this.setUpServicesAndPorts();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCredentials(Credentials credential) throws Exception {
        DDLCredentialResponse saveCredentialsResponse =null;
        try {
            //Step 3 is to instantiate the request object and set the values to the request object.
            SaveOrUpdateCredentialRequest saveOrUpdateCredentialRequest = new SaveOrUpdateCredentialRequest();
            saveOrUpdateCredentialRequest.setCredential(credential);

            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            saveCredentialsResponse=servicePortType.saveCredentials(saveOrUpdateCredentialRequest);

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            if(!(saveCredentialsResponse != null && saveCredentialsResponse.isResult())){
                throw new Exception("The request was not successful");
            }
        }

    }

    @Override
    public List<Credentials> getCredentialsList(String searchString) {
        GetCredentialsListResponse getCredentialsListResponse=null;
        try{
            //Step 3 is to instantiate the request object and set the values to the request object.
            GetCredentialsListOrDeleteCredentialRequest requestObject=
                    new GetCredentialsListOrDeleteCredentialRequest();
            requestObject.setSearchStringOrAccountId(searchString);

            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            getCredentialsListResponse=servicePortType.getCredentialsListForView(requestObject);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return getCredentialsListResponse != null ? getCredentialsListResponse.getCredentialsList() : null;
    }

    @Override
    public Credentials getCredentialForStorage(List<Credentials> searchResults, String accountId) {
        GetCredentialForStorageResponse storageResponse=null;
        try{
            //Step 3 is to instantiate the request object and set the values to the request object.
            GetCredentialForStorageRequest storageRequest=new GetCredentialForStorageRequest();
            storageRequest.setAccountId(accountId);
            storageRequest.getCredentialsList().addAll(searchResults);

            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            storageResponse=servicePortType.getCredentialForStorageInSession(storageRequest);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return storageResponse != null ? storageResponse.getCredential() : null;
    }

    @Override
    public void updateCredentials(Credentials credential) throws Exception {
        DDLCredentialResponse updateCredentialsResponse =null;
        try {
            //Step 3 is to instantiate the request object and set the values to the request object.
            SaveOrUpdateCredentialRequest saveOrUpdateCredentialRequest = new SaveOrUpdateCredentialRequest();
            saveOrUpdateCredentialRequest.setCredential(credential);

            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            updateCredentialsResponse=servicePortType.updateCredentials(saveOrUpdateCredentialRequest);

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            if(!(updateCredentialsResponse != null && updateCredentialsResponse.isResult())){
                throw new Exception("The request was not successful");
            }
        }
    }

    @Override
    public void deleteCredentials(String accountId) throws Exception {
        DDLCredentialResponse deleteCredentialsResponse =null;
        try {
            //Step 3 is to instantiate the request object and set the values to the request object.
         GetCredentialsListOrDeleteCredentialRequest deleteCredentialRequest=
                 new GetCredentialsListOrDeleteCredentialRequest();
         deleteCredentialRequest.setSearchStringOrAccountId(accountId);

            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            deleteCredentialsResponse=servicePortType.deleteCredentials(deleteCredentialRequest);

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            if(!(deleteCredentialsResponse != null && deleteCredentialsResponse.isResult())){
                throw new Exception("The request was not successful");
            }
        }
    }

    @Override
    public String sendEmail(Credentials credential, String emailId) {
        NotificationResponse notificationResponse=null;
        try{
            //Step 3 is to instantiate the request object and set the values to the request object.
            NotificationRequest notificationRequest=new NotificationRequest();
            notificationRequest.setCredential(credential);
            notificationRequest.setEmailAddress(emailId);

            //Step 4 is to call the actual web service method on the portType instance by passing the instance of the request
            //and then receive it in the reference to the response object
            notificationResponse=notificationServicePortType.sendEmail(notificationRequest);
        }catch(Exception ex){
            ex.printStackTrace();
        }

       return notificationResponse != null ? notificationResponse.getMessage() : null;
    }

    private void setUpServicesAndPorts() throws MalformedURLException {
        //Credential Service first
        //Step 1: Generate the service class instance
        //be provided with the URL of the WSDL file
        credentialsService = new CredentialManagerService(new URL(CREDENTIAL_SERVICE_URL));
        //Step 2 is to get the port type instance that wraps all the operations performed by the web service, from the
        //Service class
        servicePortType = credentialsService.getCredentialsServicePortTypePort();

        //Credential Service first
        //Step 1: Generate the service class instance
        //be provided with the URL of the WSDL file
         notificationSenderService= new NotificationSenderService(new URL(NOTIFICATION_SERVICE_URL));
        //Step 2 is to get the port type instance that wraps all the operations performed by the web service, from the
        //Service class
        notificationServicePortType = notificationSenderService.getNotificationServicePortTypePort();
    }
}
