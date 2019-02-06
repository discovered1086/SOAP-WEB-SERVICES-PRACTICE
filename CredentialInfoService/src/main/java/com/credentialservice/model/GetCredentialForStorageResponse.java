package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "GetCredentialForStorageResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCredentialForStorageResponse {
    private Credentials credential;

    public Credentials getCredential() {
        return credential;
    }

    public void setCredential(Credentials credential) {
        this.credential = credential;
    }
}
