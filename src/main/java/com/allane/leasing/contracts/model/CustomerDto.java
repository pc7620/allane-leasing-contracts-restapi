package com.allane.leasing.contracts.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto {

	private String id;

	private String firstName;
	private String lastName;
	private LocalDate birthDate;


	// constructors, getters, and setters

    public CustomerDto() {
        super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	
}
