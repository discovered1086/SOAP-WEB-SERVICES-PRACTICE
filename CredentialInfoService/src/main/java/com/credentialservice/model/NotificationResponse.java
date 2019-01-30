package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "NotificationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
