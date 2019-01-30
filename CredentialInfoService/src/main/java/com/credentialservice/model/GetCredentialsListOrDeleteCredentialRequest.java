package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "GetCredentialsListOrDeleteCredentialRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCredentialsListOrDeleteCredentialRequest {

    private String searchStringOrAccountId;

    public String getSearchStringOrAccountId() {
        return searchStringOrAccountId;
    }

    public void setSearchStringOrAccountId(String searchStringOrAccountId) {
        this.searchStringOrAccountId = searchStringOrAccountId;
    }
}
