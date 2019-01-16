package com.kingshuk.webservices.business;

import javax.xml.ws.WebFault;


public class EmployeeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2006350220544159783L;

	public EmployeeNotFoundException() {
		super("Employee could not be found...!!");
	}
	
	
	
	

}
