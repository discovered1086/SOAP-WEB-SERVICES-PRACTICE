
package com.credentialservice.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendEmail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendEmail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="notificationRequest" type="{http://business.credentialservice.com/}NotificationRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendEmail", propOrder = {
    "notificationRequest"
})
public class SendEmail {

    protected NotificationRequest notificationRequest;

    /**
     * Gets the value of the notificationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationRequest }
     *     
     */
    public NotificationRequest getNotificationRequest() {
        return notificationRequest;
    }

    /**
     * Sets the value of the notificationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationRequest }
     *     
     */
    public void setNotificationRequest(NotificationRequest value) {
        this.notificationRequest = value;
    }

}
