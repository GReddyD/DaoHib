package com.netology.daohib.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person implements Serializable {

	@Id
	@Column(name = "name")
	private String name;

	@Id
	@Column(name = "surname")
	private String surname;

	@Id
	@Column(name = "age")
	private int age;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "city_of_living")
	private String city_of_living;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
