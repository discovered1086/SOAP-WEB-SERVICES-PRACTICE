package com.kingshuk.webservices.errorresponses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="employeeResponse")
public class EmployeeResponse {
	
	@XmlElement
	private String errorCode;
	
	@XmlElement
	private String errorMessage;
	
	@XmlAttribute(name="xmlns")
	private String nameSpace="http://webservices.kingshuk.com/types";
	
	

	public String getNameSpace() {
		return nameSpace;
	}


	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}


	public String getErrorCode() {
		return errorCode;
	}

	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
