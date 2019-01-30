
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCredentialForStorageInSession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCredentialForStorageInSession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="credentialsListForStorage" type="{http://business.credentialservice.com/}GetCredentialForStorageRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCredentialForStorageInSession", propOrder = {
    "credentialsListForStorage"
})
public class GetCredentialForStorageInSession {

    protected GetCredentialForStorageRequest credentialsListForStorage;

    /**
     * Gets the value of the credentialsListForStorage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCredentialForStorageRequest }
     *     
     */
    public GetCredentialForStorageRequest getCredentialsListForStorage() {
        return credentialsListForStorage;
    }

    /**
     * Sets the value of the credentialsListForStorage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCredentialForStorageRequest }
     *     
     */
    public void setCredentialsListForStorage(GetCredentialForStorageRequest value) {
        this.credentialsListForStorage = value;
    }

}
