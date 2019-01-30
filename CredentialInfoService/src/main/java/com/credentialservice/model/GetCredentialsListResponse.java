package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "GetCredentialsListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCredentialsListResponse {

    private List<Credentials> credentialsList;

    public List<Credentials> getCredentialsList() {
        return credentialsList;
    }

    public void setCredentialsList(List<Credentials> credentialsList) {
        this.credentialsList = credentialsList;
    }
}
