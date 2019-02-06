package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kingshuk on 7/23/17.
 */
@XmlType(name = "DDLCredentialResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class DDLCredentialResponse {
    private boolean result;

    public DDLCredentialResponse() {
    }

    public DDLCredentialResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
