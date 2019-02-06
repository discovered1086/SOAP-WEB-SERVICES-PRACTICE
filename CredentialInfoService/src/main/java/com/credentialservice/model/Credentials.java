/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credentialservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author Kingshuk
 */
//The below annotation will mark this class as a complex type in the XML
//JAX-B annotations are used for Java Beans where as JAX-WS annotations
//Elements marked with the JAX-B annotations get placed in the types section of the WSDL file
//are used for interface end points
@XmlType(name = "Credentials")
//The below annotation tells JAX-B Runtime about the level in which the annotations are declared
//in this class
@XmlAccessorType(XmlAccessType.FIELD)
public class Credentials{

    //The @XmlElement is not mandatory as during serialization or marshalling
    //the XML elements will be automatically picked up from the fields of this object
    //because we have already told the JAXB runtime (Apache CXF) that our XML accessor types
    //are at the field level
    @XmlElement
    private String accountId;

    @XmlElement(required = true)
    private String account;

    @XmlElement(required = true)
    private String userId;

    @XmlElement
    private String passwordType;

    @XmlElement(required = true)
    private String password;

    @XmlElement
    private String url;

    public Credentials() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswordType() {
        return passwordType;
    }

    public void setPasswordType(String passwordType) {
        this.passwordType = passwordType;
    }
}
