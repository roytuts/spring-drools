package com.roytuts.springboot3.drools.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.springboot3.drools.dto.Employee;
import com.roytuts.springboot3.drools.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee/save")
	public ResponseEntity<String> storeEmployeeInfo(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
