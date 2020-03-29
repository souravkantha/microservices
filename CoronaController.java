package com.demo.microservice.controller;


import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.entities.CoronaDetails;
import com.demo.microservice.entities.CoronaStateWiseDetails;
import com.demo.microservice.services.CoronaService;


@RestController
@RequestMapping(value = "/service/corona", produces = "application/json")
public class CoronaController {
	
	@Autowired
	private CoronaService service;
	
	@GetMapping("/states/names")
	public Set<String> getStateNames() throws Exception {

		return service.getCoronaStateNames();

	}
	
	@GetMapping("/{country}")
	public CoronaDetails get(@PathVariable("country") String name) throws Exception {

		return service.getCoronaDetails("India");

	}
	
	@GetMapping("/states/{state}")
	public CoronaStateWiseDetails getByState(@PathVariable("state") String state) throws Exception {

		return service.getCoronaDetailsByState(state);

	}
	
	@GetMapping("/states")
	public Collection<CoronaStateWiseDetails> getByAllStates() throws Exception {

		return service.getCoronaDetailsForAllState();

	}

	

}
