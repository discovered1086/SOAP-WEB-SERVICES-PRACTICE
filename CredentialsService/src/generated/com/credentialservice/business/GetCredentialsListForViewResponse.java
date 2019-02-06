
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCredentialsListForViewResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCredentialsListForViewResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="credentialList" type="{http://business.credentialservice.com/}GetCredentialsListResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCredentialsListForViewResponse", propOrder = {
    "credentialList"
})
public class GetCredentialsListForViewResponse {

    protected GetCredentialsListResponse credentialList;

    /**
     * Gets the value of the credentialList property.
     * 
     * @return
     *     possible object is
     *     {@link GetCredentialsListResponse }
     *     
     */
    public GetCredentialsListResponse getCredentialList() {
        return credentialList;
    }

    /**
     * Sets the value of the credentialList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCredentialsListResponse }
     *     
     */
    public void setCredentialList(GetCredentialsListResponse value) {
        this.credentialList = value;
    }

}
