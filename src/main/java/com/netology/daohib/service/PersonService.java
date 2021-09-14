package com.netology.daohib.service;

import com.netology.daohib.model.Person;
import com.netology.daohib.repository.PersonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
	PersonRepository repository;

	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public List<Person> getPersonsByCity(String city){
		return repository.findByCityOfLiving(city);
	}

	public List<Person> getPersonsByAgeOrderByAgeAsc(int age){
		return repository.findByAgeOrderByAgeAsc(age, Sort.by(Sort.Direction.ASC, "composeId.age"));
	}

	public Optional<Person> getPersonByNameAndSurnam(String name, String surname){
		return repository.findByNameAndSurname(name, surname);
	}
}
