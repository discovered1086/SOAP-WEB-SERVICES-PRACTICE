
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendEmailResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendEmailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outputMessage" type="{http://business.credentialservice.com/}NotificationResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendEmailResponse", propOrder = {
    "outputMessage"
})
public class SendEmailResponse {

    protected NotificationResponse outputMessage;

    /**
     * Gets the value of the outputMessage property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationResponse }
     *     
     */
    public NotificationResponse getOutputMessage() {
        return outputMessage;
    }

    /**
     * Sets the value of the outputMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationResponse }
     *     
     */
    public void setOutputMessage(NotificationResponse value) {
        this.outputMessage = value;
    }

}
