package com.kingshuk.webservices.errorresponses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeResponse {
	
	
	private String errorCode;
	
	
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	@XmlElement
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@XmlElement
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
