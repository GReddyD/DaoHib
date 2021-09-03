package com.netology.daohib.service;

import com.netology.daohib.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
	PersonRepository repository;

	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public List getPersonsByCity(String city){
		return repository.getPersonsByCity(city);
	}
}
