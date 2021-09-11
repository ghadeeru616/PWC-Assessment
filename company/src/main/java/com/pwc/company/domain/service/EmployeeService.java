package com.pwc.company.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.company.domain.entity.Employee;
import com.pwc.company.domain.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployeeByNumber(Long employeeNumber) {
		return employeeRepository.findByEmployeeNumber(employeeNumber);
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}

	public List<Employee> getAllEmployees() {
		Iterable<Employee> employees = employeeRepository.findAll();
		return StreamSupport.stream(employees.spliterator(), false).collect(Collectors.toList());
	}

	public List<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByUserName(name);
	}

	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
}
