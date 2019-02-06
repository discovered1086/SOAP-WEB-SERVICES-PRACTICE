
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for saveCredentialsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="saveCredentialsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saveResult" type="{http://business.credentialservice.com/}DDLCredentialResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveCredentialsResponse", propOrder = {
    "saveResult"
})
public class SaveCredentialsResponse {

    protected DDLCredentialResponse saveResult;

    /**
     * Gets the value of the saveResult property.
     * 
     * @return
     *     possible object is
     *     {@link DDLCredentialResponse }
     *     
     */
    public DDLCredentialResponse getSaveResult() {
        return saveResult;
    }

    /**
     * Sets the value of the saveResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDLCredentialResponse }
     *     
     */
    public void setSaveResult(DDLCredentialResponse value) {
        this.saveResult = value;
    }

}
