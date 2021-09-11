package com.pwc.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
        .antMatchers("/Employees/get").hasRole("EMPLOYEE")
        .antMatchers("/Managers/").hasRole("MANAGER")
        .and().csrf().disable();
    }
 
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("emp").password("{noop}emp1234").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin1234").roles("MANAGER");
	}
}