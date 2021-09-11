package com.pwc.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwc.company.domain.entity.Employee;
import com.pwc.company.domain.service.EmployeeService;

@RestController
@RequestMapping(value = "/Employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/get/{empNumber}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name = "empNumber", required = true) Long employeeNumber) {
		 
		Employee employeeDetails = employeeService.getEmployeeByNumber(employeeNumber);
		 
		 if(employeeDetails == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<>(employeeDetails, HttpStatus.CREATED);
	}
}
