package com.netology.daohib.repository;

import com.netology.daohib.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
@Transactional
public class PersonRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List getPersonsByCity(String city){
		generatePersonsInTable();

		Query query = entityManager.createQuery("select p from Person p where p.city_of_living = :city", Person.class);
		query.setParameter("city", city);
		var resultList = query.getResultList();
		return resultList;
	}

	public void generatePersonsInTable() {

		var names = List.of("Алексей", "Александр", "Егор", "Игорь");
		var surnames = List.of("Алексеев", "Александров", "Егоров", "Игорев");
		var cities = List.of("Moscow", "Berlin", "Moscow", "Tver");

		var random = new Random();
		IntStream.range(0, 50)
						.forEach(i -> {
							var person = Person.builder()
											.name(names.get(random.nextInt(names.size())))
											.surname(surnames.get(random.nextInt(surnames.size())))
											.age(random.nextInt(60))
											.phone_number(String.valueOf((random.nextInt(8999999) + 1000000)))
											.city_of_living(cities.get(random.nextInt(cities.size())))
											.build();
							entityManager.persist(person);
						});
	}
}
