package com.netology.daohib.controller;

import com.netology.daohib.model.Person;
import com.netology.daohib.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/persons/by-age")
	public List getPersonsByAgeOrderByAgeAsc(int age){
		var resultList = service.getPersonsByAgeOrderByAgeAsc(age);
		resultList.forEach(System.out::println);
		return resultList;
	}

	@GetMapping("/persons/by-name-surname")
	public Optional<Person> getPersonByNameAndSurnam(String name, String surname){
		var resultOptional = service.getPersonByNameAndSurnam(name, surname);
		System.out.println(resultOptional.toString());
		return resultOptional;
	}
}
