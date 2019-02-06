
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCredentialForStorageInSessionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCredentialForStorageInSessionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="singleCredentialInformation" type="{http://business.credentialservice.com/}GetCredentialForStorageResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCredentialForStorageInSessionResponse", propOrder = {
    "singleCredentialInformation"
})
public class GetCredentialForStorageInSessionResponse {

    protected GetCredentialForStorageResponse singleCredentialInformation;

    /**
     * Gets the value of the singleCredentialInformation property.
     * 
     * @return
     *     possible object is
     *     {@link GetCredentialForStorageResponse }
     *     
     */
    public GetCredentialForStorageResponse getSingleCredentialInformation() {
        return singleCredentialInformation;
    }

    /**
     * Sets the value of the singleCredentialInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCredentialForStorageResponse }
     *     
     */
    public void setSingleCredentialInformation(GetCredentialForStorageResponse value) {
        this.singleCredentialInformation = value;
    }

}
