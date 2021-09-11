package com.pwc.company.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwc.company.domain.dto.EmployeeProjectAssignmnet;
import com.pwc.company.domain.entity.Department;
import com.pwc.company.domain.entity.Employee;
import com.pwc.company.domain.entity.Project;
import com.pwc.company.domain.service.DepartmentService;
import com.pwc.company.domain.service.EmployeeService;
import com.pwc.company.domain.service.ManagerService;
import com.pwc.company.domain.service.ProjectService;

@RestController
@RequestMapping(value = "/Managers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ManagerService managerService;
	
	@GetMapping(path = "/EmployeesByDepartment/{departmentCode}")
	public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable(name = "departmentCode", required = true) String departmentCode) {
		List<Employee> employeesOfDepartment = managerService.getEmployeesOfDepartment(departmentCode);
		return new ResponseEntity<>(employeesOfDepartment, HttpStatus.OK);
	}
	
	@GetMapping(path = "/EmployeesByProject/{projectCode}")
	public ResponseEntity<List<Employee>> getEmployeesByProject(@PathVariable(name = "projectCode", required = true) String projectCode) {
		List<Employee> employeesOfDepartment = managerService.getEmployeesOfProject(projectCode);
		return new ResponseEntity<>(employeesOfDepartment, HttpStatus.OK);
	}
	
	@GetMapping(path = "/AllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping(path = "/EmpByName/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable(name = "name", required = true) String employeeName) {
		List<Employee> employees = employeeService.getEmployeeByName(employeeName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping(path = "/EmpByEmail/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(name = "email", required = true) String employeeEmail) {
		Employee employee = employeeService.getEmployeeByEmail(employeeEmail);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping(path = { "/createEmployee", "/updateEmployee" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/deleteEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee employee) {

		employeeService.deleteEmployee(employee);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping(path = "/AllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		List<Department> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@PostMapping(path = { "/createDepartment", "/updateDepartment" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {

		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/deleteDepartment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> deleteDepartment(@RequestBody Department department) {

		departmentService.deleteDepartment(department);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/AllProjects")
	public ResponseEntity<List<Project>> getAllProjects(){
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	@PostMapping(path = { "/createProject", "/updateProject" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> createDepartment(@RequestBody Project project) {

		Project savedProject = projectService.saveProject(project);
		return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/deleteProject", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> deleteProject(@RequestBody Project project) {

		projectService.deleteProject(project);
		return new ResponseEntity<>( HttpStatus.OK);
	}

	@PostMapping(path = "/assignToProject", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> assignEmployeeToProject(@RequestBody EmployeeProjectAssignmnet assignmnet) {

		Employee employee = managerService.assignEmployeeToProject(assignmnet.getEmployeeNumber(),assignmnet.getProjectCode());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping(path = "/unAssignFromProject", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> unAssignEmployeeFromProject(@RequestBody EmployeeProjectAssignmnet assignmnet) {

		Employee employee = managerService.unAssignEmployeeFromProject(assignmnet.getEmployeeNumber(),assignmnet.getProjectCode());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
