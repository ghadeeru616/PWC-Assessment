package com.pwc.company.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String name;

	@NonNull
	@Column(unique=true)
	private String code;
	
	@OneToMany(targetEntity = Employee.class, cascade = { CascadeType.PERSIST,CascadeType.MERGE ,CascadeType.REFRESH})
	private List<Employee> employees; 

	public Department() {
	}
	
	@PreRemove
	public void PreRemove() {
		if (!this.employees.isEmpty()) {
			throw new RuntimeException("Can't remove a department that has employees.");
		}
	}

	@Override
	public String toString() {
		return String.format("Department[id=%d, name='%s', code='%s']", id, name, code);
	}

}