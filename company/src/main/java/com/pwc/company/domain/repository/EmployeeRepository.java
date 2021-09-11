package com.pwc.company.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pwc.company.domain.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Employee findByEmployeeNumber(long employeeNumber);

	List<Employee> findByUserName(String name);

	Employee findByEmail(String email);

}