
package com.kingshuk.webservices.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employeeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="employeeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FULL_TIME"/&gt;
 *     &lt;enumeration value="PART_TIME"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "employeeType")
@XmlEnum
public enum EmployeeType {

    FULL_TIME,
    PART_TIME;

    public String value() {
        return name();
    }

    public static EmployeeType fromValue(String v) {
        return valueOf(v);
    }

}
