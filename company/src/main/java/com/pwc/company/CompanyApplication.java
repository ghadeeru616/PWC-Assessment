package com.pwc.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication {

	public static final Logger log = LoggerFactory.getLogger(CompanyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

}
