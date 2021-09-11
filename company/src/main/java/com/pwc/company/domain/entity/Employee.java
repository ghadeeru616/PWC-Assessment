package com.pwc.company.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	@Column(unique=true)
	private Long employeeNumber;
	private String employeeType;
	private String speciality;
	@NonNull
	@Column(unique=true)
	private String email;
	private Double salary;

	@OneToOne(targetEntity = User.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.REFRESH})
	private User user;
	
	@NonNull
	@OneToOne(targetEntity = Department.class, cascade = { CascadeType.PERSIST,CascadeType.MERGE ,CascadeType.REFRESH})
	private Department department;
	
	@ManyToMany(targetEntity = Project.class, cascade = { CascadeType.PERSIST,CascadeType.MERGE ,CascadeType.REFRESH})
	private List<Project> projects; 

	public Employee() {
	}

	@Override
	public String toString() {
		return String.format(
				"Employee[id=%d, employeeNumber=%d, employeeType='%s' ,speciality='%s', email='%s' ,salary=%d , User='%s']",
				id, employeeNumber, employeeType, speciality, email, salary, user.toString());
	}

}