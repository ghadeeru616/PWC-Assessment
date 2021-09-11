package com.pwc.company.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.pwc.company.domain.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	Department findByCode(String code);
}