
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCredentialsListOrDeleteCredentialRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCredentialsListOrDeleteCredentialRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchStringOrAccountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCredentialsListOrDeleteCredentialRequest", propOrder = {
    "searchStringOrAccountId"
})
public class GetCredentialsListOrDeleteCredentialRequest {

    protected String searchStringOrAccountId;

    /**
     * Gets the value of the searchStringOrAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchStringOrAccountId() {
        return searchStringOrAccountId;
    }

    /**
     * Sets the value of the searchStringOrAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchStringOrAccountId(String value) {
        this.searchStringOrAccountId = value;
    }

}
