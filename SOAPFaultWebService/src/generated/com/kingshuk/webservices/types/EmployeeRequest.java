
package com.kingshuk.webservices.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employeeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="employeeRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requestForEmployee" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="excludeKingshuk" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeRequest", propOrder = {
    "requestForEmployee",
    "excludeKingshuk"
})
public class EmployeeRequest {

    protected int requestForEmployee;
    protected boolean excludeKingshuk;

    /**
     * Gets the value of the requestForEmployee property.
     * 
     */
    public int getRequestForEmployee() {
        return requestForEmployee;
    }

    /**
     * Sets the value of the requestForEmployee property.
     * 
     */
    public void setRequestForEmployee(int value) {
        this.requestForEmployee = value;
    }

    /**
     * Gets the value of the excludeKingshuk property.
     * 
     */
    public boolean isExcludeKingshuk() {
        return excludeKingshuk;
    }

    /**
     * Sets the value of the excludeKingshuk property.
     * 
     */
    public void setExcludeKingshuk(boolean value) {
        this.excludeKingshuk = value;
    }

}
