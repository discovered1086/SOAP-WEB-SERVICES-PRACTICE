
package com.kingshuk.webservices.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="tyoeOfEmployee" type="{http://webservices.kingshuk.com/types}employeeType"/&gt;
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
    "excludeKingshuk",
    "tyoeOfEmployee"
})
public class EmployeeRequest {

    protected int requestForEmployee;
    protected boolean excludeKingshuk;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EmployeeType tyoeOfEmployee;

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

    /**
     * Gets the value of the tyoeOfEmployee property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeType }
     *     
     */
    public EmployeeType getTyoeOfEmployee() {
        return tyoeOfEmployee;
    }

    /**
     * Sets the value of the tyoeOfEmployee property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeType }
     *     
     */
    public void setTyoeOfEmployee(EmployeeType value) {
        this.tyoeOfEmployee = value;
    }

}
