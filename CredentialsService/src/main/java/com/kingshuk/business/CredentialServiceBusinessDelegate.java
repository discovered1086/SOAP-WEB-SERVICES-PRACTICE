package com.kingshuk.business;



import com.credentialservice.business.*;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by kingshuk on 7/23/17.
 */
public interface CredentialServiceBusinessDelegate {
    public static final String CREDENTIAL_SERVICE_URL =
            "http://localhost:7001/CredentialInfoService/services/credentialInfoService?wsdl";
    public static final String NOTIFICATION_SERVICE_URL =
            "http://localhost:7001/CredentialInfoService/services/notificationService?wsdl";



    void saveCredentials(Credentials credential) throws Exception;

    List<Credentials> getCredentialsList(String searchString);

    Credentials getCredentialForStorage(List<Credentials> searchResults, String accountId);

    void updateCredentials(Credentials credential) throws Exception;

    void deleteCredentials(String accountId) throws Exception;

    String sendEmail(Credentials credential, String emailId);
}
