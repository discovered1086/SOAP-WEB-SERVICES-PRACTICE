
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteCredentials complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteCredentials">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://business.credentialservice.com/}GetCredentialsListOrDeleteCredentialRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCredentials", propOrder = {
    "accountId"
})
public class DeleteCredentials {

    protected GetCredentialsListOrDeleteCredentialRequest accountId;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link GetCredentialsListOrDeleteCredentialRequest }
     *     
     */
    public GetCredentialsListOrDeleteCredentialRequest getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCredentialsListOrDeleteCredentialRequest }
     *     
     */
    public void setAccountId(GetCredentialsListOrDeleteCredentialRequest value) {
        this.accountId = value;
    }

}
