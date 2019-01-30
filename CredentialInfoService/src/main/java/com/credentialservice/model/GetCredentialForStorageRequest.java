package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "GetCredentialForStorageRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCredentialForStorageRequest {
    private List<Credentials> credentialsList;

    private String accountId;

    public List<Credentials> getCredentialsList() {
        return credentialsList;
    }

    public void setCredentialsList(List<Credentials> credentialsList) {
        this.credentialsList = credentialsList;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

