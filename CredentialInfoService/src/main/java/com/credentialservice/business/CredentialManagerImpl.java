package com.credentialservice.business;

import com.credentialservice.model.*;
import com.credentialservice.model.dao.CredentialsDAO;
import com.credentialservice.model.dao.CredentialsDAOImpl;

/**
 * Created by kingshuk on 7/22/17.
 */
public class CredentialManagerImpl implements CredentialManager {
    private CredentialsDAO credentialsDAO = null;

    public CredentialManagerImpl() {
        credentialsDAO = new CredentialsDAOImpl();
    }

    @Override
    public DDLCredentialResponse saveCredentials(SaveOrUpdateCredentialRequest credential) {
        try {
            credentialsDAO.saveCredentials(credential.getCredential());
            return new DDLCredentialResponse(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new DDLCredentialResponse(false);
        }
    }

    @Override
    public GetCredentialsListResponse getCredentialsListForView(GetCredentialsListOrDeleteCredentialRequest searchStringRequest) {
        GetCredentialsListResponse getCredentialsListResponseToClient = null;
        try {
            getCredentialsListResponseToClient = new GetCredentialsListResponse();
            getCredentialsListResponseToClient.setCredentialsList(credentialsDAO.getSearchResults(searchStringRequest.getSearchStringOrAccountId()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getCredentialsListResponseToClient;
    }

    @Override
    public GetCredentialForStorageResponse getCredentialForStorageInSession(GetCredentialForStorageRequest storageRequest) {
        Integer index = 0;
        GetCredentialForStorageResponse storageResponse = null;
        for (Credentials credential : storageRequest.getCredentialsList()) {
            if (credential.getAccountId().equals(storageRequest.getAccountId())) {
                index = storageRequest.getCredentialsList().indexOf(credential);
                storageResponse = new GetCredentialForStorageResponse();
                storageResponse.setCredential(storageRequest.getCredentialsList().get(index));
                break;
            }
        }
        return storageResponse;
    }


    @Override
    public DDLCredentialResponse updateCredentials(SaveOrUpdateCredentialRequest credentialsUpdateRequest) {
        try {
            credentialsDAO.updateCredentials(credentialsUpdateRequest.getCredential());
            return new DDLCredentialResponse(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new DDLCredentialResponse(false);
        }
    }

    @Override
    public DDLCredentialResponse deleteCredentials(GetCredentialsListOrDeleteCredentialRequest accountIdRequest) {
        try {
            credentialsDAO.deleteCredentials(accountIdRequest.getSearchStringOrAccountId());
            return new DDLCredentialResponse(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new DDLCredentialResponse(false);
        }
    }
}
