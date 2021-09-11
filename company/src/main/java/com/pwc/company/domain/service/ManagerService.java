package com.pwc.company.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.company.domain.entity.Department;
import com.pwc.company.domain.entity.Employee;
import com.pwc.company.domain.entity.Project;

@Service
public class ManagerService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private DepartmentService departmentService;

	public Employee assignEmployeeToProject(Long employeeNumber, String projectCode) {

		Project project = projectService.getProjectByCode(projectCode);
		Employee employee = employeeService.getEmployeeByNumber(employeeNumber);
		employee.getProjects().add(project);

		return employeeService.saveEmployee(employee);
	}

	public Employee unAssignEmployeeFromProject(Long employeeNumber, String projectCode) {

		Project projectToRemove = null;

		Employee employee = employeeService.getEmployeeByNumber(employeeNumber);
		List<Project> projects = employee.getProjects();
		for (Project project : projects) {
			if (project.getCode() != null && project.getCode().equalsIgnoreCase(projectCode)) {
				projectToRemove = project;
				break;
			}
		}

		if (projectToRemove != null) {
			projects.remove(projectToRemove);
		}

		return employeeService.saveEmployee(employee);
		
	}
	
	public List<Employee> getEmployeesOfDepartment(String departmentCode) {
		Department department = departmentService.getDepartmentByCode(departmentCode);
		return (department != null) ? department.getEmployees() : new ArrayList<>();
	}
	
	public List<Employee> getEmployeesOfProject(String projectCode) {
		Project project = projectService.getProjectByCode(projectCode);
		return (project != null) ? project.getEmployees() : new ArrayList<>();
	}
}
