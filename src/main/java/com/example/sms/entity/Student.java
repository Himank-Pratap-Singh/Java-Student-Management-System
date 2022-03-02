package com.example.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// we have to make this simple java class as an jpa entity by using annotation
// The Java Persistence API (JPA) is a specification of Java. It is used to persist data between Java object and relational database.
// JPA acts as a bridge between object-oriented domain models and relational database systems.
@Entity
@Table(name = "students")
public class Student {
	
	// A primary key for this table using id as an annotation
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// This is for building column in a database table
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	// whenever you create a parameterized Constructor we should also make the default constructor for the class, 
	// because hibernate internally uses proxies to create object dynamically and it default constructor for that.
	public Student() {
		
		
		
	}
	
	// this is  parameterized constructor .
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	// Getter and Setter for our private variables.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
