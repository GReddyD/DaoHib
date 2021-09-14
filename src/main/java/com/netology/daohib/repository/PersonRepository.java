package com.netology.daohib.repository;

import com.netology.daohib.model.ComposeId;
import com.netology.daohib.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, ComposeId> {
	@Query(value = "select p from Person p where p.cityOfLiving = :cityOfLiving")
	List<Person> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

	@Query(value = "select p from Person p where p.composeId.age < :age")
	List<Person> findByAgeOrderByAgeAsc(@Param("age") int age, Sort sort);

	@Query(value = "select p from Person p where p.composeId.name = :name and p.composeId.surname = :surname")
	Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
