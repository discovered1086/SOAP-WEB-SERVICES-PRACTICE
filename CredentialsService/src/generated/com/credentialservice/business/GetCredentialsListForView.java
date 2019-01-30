
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCredentialsListForView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCredentialsListForView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchString" type="{http://business.credentialservice.com/}GetCredentialsListOrDeleteCredentialRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCredentialsListForView", propOrder = {
    "searchString"
})
public class GetCredentialsListForView {

    protected GetCredentialsListOrDeleteCredentialRequest searchString;

    /**
     * Gets the value of the searchString property.
     * 
     * @return
     *     possible object is
     *     {@link GetCredentialsListOrDeleteCredentialRequest }
     *     
     */
    public GetCredentialsListOrDeleteCredentialRequest getSearchString() {
        return searchString;
    }

    /**
     * Sets the value of the searchString property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCredentialsListOrDeleteCredentialRequest }
     *     
     */
    public void setSearchString(GetCredentialsListOrDeleteCredentialRequest value) {
        this.searchString = value;
    }

}
