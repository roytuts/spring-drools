package com.roytuts.springboot3.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.springboot3.drools.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private KieContainer kieContainer;

	public void saveEmployee(Employee employee) {
		KieSession kieSession = kieContainer.newKieSession();
		
		kieSession.insert(employee); // which object to validate
		kieSession.fireAllRules(); // fire all rules defined into drool file (EmployeeValidation.drl)
		kieSession.dispose();

		// once validation passed, save employee object to database
	}

}
