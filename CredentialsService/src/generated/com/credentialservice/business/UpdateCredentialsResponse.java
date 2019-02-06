
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateCredentialsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateCredentialsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateResult" type="{http://business.credentialservice.com/}DDLCredentialResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCredentialsResponse", propOrder = {
    "updateResult"
})
public class UpdateCredentialsResponse {

    protected DDLCredentialResponse updateResult;

    /**
     * Gets the value of the updateResult property.
     * 
     * @return
     *     possible object is
     *     {@link DDLCredentialResponse }
     *     
     */
    public DDLCredentialResponse getUpdateResult() {
        return updateResult;
    }

    /**
     * Sets the value of the updateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DDLCredentialResponse }
     *     
     */
    public void setUpdateResult(DDLCredentialResponse value) {
        this.updateResult = value;
    }

}
