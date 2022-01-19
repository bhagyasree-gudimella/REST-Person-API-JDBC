package com.lavanya.gudimella.service;

import java.sql.SQLException;

import com.lavanya.gudimella.dao.PersonDao;
import com.lavanya.gudimella.vo.Person;

public class PersonService {
	
	public void addPerson(Person person) throws SQLException {
		PersonDao personDao = new PersonDao();
		personDao.addPerson(person);
	}

	public Person getPerson(String person_id) throws SQLException {
		PersonDao personDao = new PersonDao();
		Person person = personDao.getPerson(person_id);
		return person;
	}

	public void updatePerson(Person person) throws SQLException {
		PersonDao personDao = new PersonDao();
		personDao.updatePerson(person);
	}

	public void deletePerson(String email_address) throws SQLException {
		PersonDao personDao = new PersonDao();
		personDao.deletePerson(email_address);
	}

	public boolean findPerson(String email_address) throws SQLException {
		PersonDao personDao = new PersonDao();
		return personDao.findPerson(email_address);
	}
}
