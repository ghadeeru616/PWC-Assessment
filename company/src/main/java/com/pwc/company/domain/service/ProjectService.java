package com.pwc.company.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.company.domain.entity.Project;
import com.pwc.company.domain.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project getProjectByCode(String code) {
		return projectRepository.findByCode(code);
	}

	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}

	public List<Project> getAllProjects() {
		Iterable<Project> projects = projectRepository.findAll();
		return StreamSupport.stream(projects.spliterator(), false).collect(Collectors.toList());
	}
}
