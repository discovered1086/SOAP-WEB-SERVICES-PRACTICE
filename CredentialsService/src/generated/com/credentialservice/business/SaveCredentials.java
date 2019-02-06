
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for saveCredentials complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="saveCredentials">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saveCredentialRequest" type="{http://business.credentialservice.com/}SaveOrUpdateCredentialRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveCredentials", propOrder = {
    "saveCredentialRequest"
})
public class SaveCredentials {

    protected SaveOrUpdateCredentialRequest saveCredentialRequest;

    /**
     * Gets the value of the saveCredentialRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SaveOrUpdateCredentialRequest }
     *     
     */
    public SaveOrUpdateCredentialRequest getSaveCredentialRequest() {
        return saveCredentialRequest;
    }

    /**
     * Sets the value of the saveCredentialRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveOrUpdateCredentialRequest }
     *     
     */
    public void setSaveCredentialRequest(SaveOrUpdateCredentialRequest value) {
        this.saveCredentialRequest = value;
    }

}
