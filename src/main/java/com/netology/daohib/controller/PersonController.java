package com.netology.daohib.controller;

import com.netology.daohib.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {
	PersonService service;

	public PersonController(PersonService service) {
		this.service = service;
	}

	@GetMapping("/persons/by-city")
	public List getPersonsByCity(String city){
		var resultList = service.getPersonsByCity(city);
		resultList.forEach(System.out::println);
		return resultList;
	}
}
