
package com.studentinfoservice.student;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for course.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="course">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IT"/>
 *     &lt;enumeration value="CSE"/>
 *     &lt;enumeration value="MECH"/>
 *     &lt;enumeration value="AUE"/>
 *     &lt;enumeration value="ECE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "course")
@XmlEnum
public enum Course {

    IT,
    CSE,
    MECH,
    AUE,
    ECE;

    public String value() {
        return name();
    }

    public static Course fromValue(String v) {
        return valueOf(v);
    }

}
