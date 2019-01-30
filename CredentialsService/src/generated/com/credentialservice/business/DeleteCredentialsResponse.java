
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteCredentialsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteCredentialsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deleteResult" type="{http://business.credentialservice.com/}DDLCredentialResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCredentialsResponse", propOrder = {
    "deleteResult"
})
public class DeleteCredentialsResponse {

    protected DDLCredentialResponse deleteResult;

    /**
     * Gets the value of the deleteResult property.
     * 
     * @return
     *     possible object is
     *     {@link DDLCredentialResponse }
     *     
     */
    public DDLCredentialResponse getDeleteResult() {
        return deleteResult;
    }

    /**
     * Sets the value of the deleteResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDLCredentialResponse }
     *     
     */
    public void setDeleteResult(DDLCredentialResponse value) {
        this.deleteResult = value;
    }

}
