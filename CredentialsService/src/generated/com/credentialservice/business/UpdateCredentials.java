
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateCredentials complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateCredentials">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="credentials" type="{http://business.credentialservice.com/}SaveOrUpdateCredentialRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCredentials", propOrder = {
    "credentials"
})
public class UpdateCredentials {

    protected SaveOrUpdateCredentialRequest credentials;

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link SaveOrUpdateCredentialRequest }
     *     
     */
    public SaveOrUpdateCredentialRequest getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveOrUpdateCredentialRequest }
     *     
     */
    public void setCredentials(SaveOrUpdateCredentialRequest value) {
        this.credentials = value;
    }

}
