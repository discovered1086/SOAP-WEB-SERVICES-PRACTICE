
package com.credentialservice.model.dao;

import com.credentialservice.model.Credentials;

import java.util.List;

/**
 * Created by kingshuk on 7/22/17.
 */
public interface CredentialsDAO {

    void saveCredentials(Credentials credentials) throws Exception;

    List<Credentials> getSearchResults(String searchString) throws Exception;

    void updateCredentials(Credentials credential) throws Exception;

    void deleteCredentials(String account_id) throws Exception;
}
