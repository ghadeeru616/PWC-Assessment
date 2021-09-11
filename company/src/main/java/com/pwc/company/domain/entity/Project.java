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

@Data
@Entity
public class Project {

	@Id
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private String name;
	@NonNull
	@Column(unique=true)
	private String code;
	
	@OneToOne(targetEntity = Department.class,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private Department department;
	
	@ManyToMany(targetEntity = Employee.class, cascade = { CascadeType.PERSIST,CascadeType.MERGE ,CascadeType.REFRESH})
	private List<Employee> employees; 
	
	public Project() {
	}

	@Override
	public String toString() {
		return String.format("Project[id=%d, name='%s', code='%s']", id, name, code);
	}

}