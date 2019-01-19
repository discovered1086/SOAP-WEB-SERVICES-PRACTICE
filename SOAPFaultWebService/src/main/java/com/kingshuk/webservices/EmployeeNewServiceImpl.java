package com.kingshuk.webservices;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.kingshuk.webservices.types.Employee;
import com.kingshuk.webservices.types.EmployeeRequest;
import com.kingshuk.webservices.types.EmployeeResponse;


public class EmployeeNewServiceImpl implements GetEmployeePortType {

	@Override
	public EmployeeResponse getEmployeeOperation(EmployeeRequest parameters) throws HttpStatusCodeException {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee =null;
		try {
		employee = restTemplate.getForObject(
				"http://localhost:8082/RESTWebServiceApplication/employee/" + parameters.getRequestForEmployee(),
				Employee.class);
		
		if(employee==null) {
			throw new HttpServerErrorException(HttpStatus.NO_CONTENT, "Didn't find the employee, sorry Boss....!!!");
		}
		}catch(HttpStatusCodeException ex) {
			throw ex;
		}
		EmployeeResponse response = new EmployeeResponse();

		response.setResponseForEmployee(employee);

		return response;
	}



}
