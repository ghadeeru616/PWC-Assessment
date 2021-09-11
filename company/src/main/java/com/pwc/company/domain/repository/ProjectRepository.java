package com.pwc.company.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.pwc.company.domain.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	Project findByCode(String code);
}