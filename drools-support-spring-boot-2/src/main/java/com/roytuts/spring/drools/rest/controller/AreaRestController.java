package com.roytuts.spring.drools.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.drools.vo.AreaPin;

@RestController
public class AreaRestController {

	@Autowired
	private KieContainer kieContainer;

	@GetMapping("/area/name/{pinCode}")
	public ResponseEntity<String> getAreaByPinCode(@PathVariable int pinCode) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(new AreaPin(pinCode)); // which object to validate
		kieSession.fireAllRules(); // fire all rules defined into drool file (drl)
		kieSession.dispose();

		return new ResponseEntity<String>(getAreaByCode(pinCode), HttpStatus.OK);
	}

	private String getAreaByCode(int pin) {
		final Map<Integer, String> areaMap = new HashMap<>();

		areaMap.put(700001, "BBD Bag");
		areaMap.put(700010, "Beliaghata");
		areaMap.put(700105, "Nabapally");
		areaMap.put(700098, "Sukanta Nagar");

		return areaMap.getOrDefault(pin, "Area not found");
	}
}
