package com.kingshuk.webservices;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import com.kingshuk.webservices.types.Employee;
import com.kingshuk.webservices.types.EmployeeRequest;
import com.kingshuk.webservices.types.EmployeeResponse;
import com.kingshuk.webservices.types.SchemaValidationExceptionType;
import com.kingshuk.webservices.GetEmployeePortType;

public class EmployeeServiceImpl implements GetEmployeePortType{

	private static Map<Integer, Employee> employeeMap;

	static {
		employeeMap = new HashMap<>();
		Employee employee = new Employee();
		employee.setEmployeeId(232649);
		employee.setEmployeeName("Kingshuk Mukherjee");
		employeeMap.put(employee.getEmployeeId(), employee);
	}

	@Override
	public EmployeeResponse getEmployeeOperation(EmployeeRequest employeeRequest) throws SchemaValidationExceptionMessage {
		int employeeId = employeeRequest.getRequestForEmployee();
		System.out.println("It reached my endpoint. Yahoooo....!!!");
		EmployeeResponse response = new EmployeeResponse();

		if (employeeMap.containsKey(employeeId)) {
			response.setResponseForEmployee(employeeMap.get(employeeId));
			return response;
		}else {
			SchemaValidationExceptionType schemaValidationError = new SchemaValidationExceptionType();
			schemaValidationError.setReasonCode(4589);
			schemaValidationError.setReasonText("Employee does not exist");
			throw new SchemaValidationExceptionMessage(null, schemaValidationError);
		}
		

		
	}

	

}
