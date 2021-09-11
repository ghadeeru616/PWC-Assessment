package com.pwc.company.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String gender;
	private String nationality;
	private Long age;

	public User() {
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, Name='%s', gender='%s' , nationality='%s', age='%d' ]",
				id, name, gender, nationality, age);
	}

}