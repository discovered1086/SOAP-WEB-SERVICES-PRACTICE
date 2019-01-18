package com.kingshuk.webservices.errorresponses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="employeeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="employeeResponse")
public class EmployeeResponse extends PreEndpointErrorResponses {

}
