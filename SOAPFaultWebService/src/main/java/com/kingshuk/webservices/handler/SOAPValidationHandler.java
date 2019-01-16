package com.kingshuk.webservices.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.springframework.http.HttpStatus;

import com.kingshuk.webservices.types.Employee;
import com.kingshuk.webservices.types.EmployeeResponse;

public class SOAPValidationHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("This reached the handler fault method");

		SOAPMessage message = context.getMessage();

		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope soapEnvelope;

		try {
			soapEnvelope = soapPart.getEnvelope();
			SOAPBody soapBody = soapEnvelope.getBody();
			soapBody.removeContents();
			System.out.println(context.get(MessageContext.HTTP_RESPONSE_CODE));
			context.put(MessageContext.HTTP_RESPONSE_CODE, new Integer(200));
			Employee employee = new Employee();
			employee.setEmployeeId(12345);
			employee.setEmployeeName("Pelam Na Baba");

			EmployeeResponse response = new EmployeeResponse();

			response.setResponseForEmployee(employee);

			SOAPElement responseElement = soapBody.addBodyElement(
					soapEnvelope.createName("employeeResponse", "ns2", "http://webservices.kingshuk.com/types"));

			SOAPElement responseForEmployeeElement = responseElement.addChildElement("responseForEmployee");

			// responseForEmployeeElement.addChildElement("employeeId").addTextNode(String.valueOf(employee.getEmployeeId()));

			responseForEmployeeElement.addChildElement("reasonCode").addTextNode("559");

			// responseForEmployeeElement.addChildElement("employeeName").addTextNode(employee.getEmployeeName());
			responseForEmployeeElement.addChildElement("ErrorDescription")
					.addTextNode("Missing or invalid request values provided");

			
		} catch (SOAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public void close(MessageContext context) {

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
