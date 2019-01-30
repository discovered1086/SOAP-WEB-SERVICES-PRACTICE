package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "NotificationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationRequest {
    private String emailAddress;
    private Credentials credential;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Credentials getCredential() {
        return credential;
    }

    public void setCredential(Credentials credential) {
        this.credential = credential;
    }
}
