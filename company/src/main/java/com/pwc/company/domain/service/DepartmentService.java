package com.pwc.company.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.company.domain.entity.Department;
import com.pwc.company.domain.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department getDepartmentByCode(String code) {
		return departmentRepository.findByCode(code);
	}

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public void deleteDepartment(Department department) {
		departmentRepository.delete(department);
	}

	public List<Department> getAllDepartments() {
		Iterable<Department> departments = departmentRepository.findAll();
		return StreamSupport.stream(departments.spliterator(), false).collect(Collectors.toList());
	}
}
