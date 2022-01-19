package com.lavanya.gudimella.dto;

import com.lavanya.gudimella.vo.Person;

public class PersonResponse {
	
	private String response;
	private Person person;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "PersonResponse [response=" + response + ", person=" + person + "]";
	}
}
