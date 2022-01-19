package com.lavanya.gudimella.resource;

import java.sql.SQLException; 

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.service.PersonService;
import com.lavanya.gudimella.vo.Person;

@Path("/person")
public class PersonResource {
	
	@GET
	@Path("/sayHello")
	@Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON}) 
	// good to have both media types, cause client might send data in both xml or Json formats
	public PersonResponse sayHello() {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResponse("Hello Jersey-REST");
		return personResponse;
	}
	
	@POST
	@Path("/addPerson")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PersonResponse addPerson(Person person) throws SQLException {
		PersonService personService = new PersonService();
		PersonResponse personResponse = new PersonResponse();
		personService.addPerson(person);
		personResponse.setResponse(person.getEmail_address() +", Person has been added successfully");
		personResponse.setPerson(person);
		return personResponse;
	}
	
	@GET
	@Path("/{person_id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//default json format
	public PersonResponse getPerson(@PathParam("person_id") String person_id) throws SQLException  {
		PersonService personService = new PersonService();
		PersonResponse personResponse = new PersonResponse();
		Person person = personService.getPerson(person_id);
		personResponse.setResponse(person.getEmail_address() +", Person Found");
		personResponse.setPerson(person);
		return personResponse;
	}
	
	@PUT
	@Path("/updatePerson")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PersonResponse updatePerson(Person person) throws SQLException {
		PersonService personService = new PersonService();
		PersonResponse personResponse = new PersonResponse();
		personService.updatePerson(person);
		personResponse.setResponse(person.getEmail_address() +", Person has been updated successfully");
		personResponse.setPerson(person);
		return personResponse;
	}
	
	@DELETE
	@Path("/deletePerson/{email_address}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PersonResponse deletePerson(@PathParam("email_address") String email_address) throws SQLException {
		PersonService personService = new PersonService();
		PersonResponse personResponse = new PersonResponse();
		personService.deletePerson(email_address);
		personResponse.setResponse(email_address +", Person has been deleted successfully");
		return personResponse;
	}
}
