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
		Query query = entityManager.createQuery("select p from Person p where p.city_of_living = :city", Person.class);
		query.setParameter("city", city);
		var resultList = query.getResultList();
		return resultList;
	}
}
