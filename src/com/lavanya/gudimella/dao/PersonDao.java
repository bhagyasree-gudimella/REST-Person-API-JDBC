package com.lavanya.gudimella.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lavanya.gudimella.jdbc.DatabaseConnection;
import com.lavanya.gudimella.vo.Person;

public class PersonDao {
	
	private DatabaseConnection databaseConnection;
	
	public void addPerson(Person person) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		
		String query = "insert into Person(first_name, middle_name, last_name, email_address, gender, address, city, state, country, zipcode, phone_number, bank_name, account_details, ssn_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getFirst_name());
		preparedStatement.setString(2, person.getMiddle_name());
		preparedStatement.setString(3, person.getLast_name());
		preparedStatement.setString(4, person.getEmail_address());
		preparedStatement.setString(5, person.getGender());
		preparedStatement.setString(6, person.getAddress());
		preparedStatement.setString(7, person.getCity());
		preparedStatement.setString(8, person.getState());
		preparedStatement.setString(9, person.getCountry());
		preparedStatement.setString(10, person.getZipcode());
		preparedStatement.setString(11, person.getPhone_number());
		preparedStatement.setString(12, person.getBank_name());
		preparedStatement.setString(13, person.getAccount_details());
		preparedStatement.setString(14, person.getSsn_number());

		int result = preparedStatement.executeUpdate();
		if (result > 0) {
			System.out.println("Person has been successfully inserted into database");
		}
	}

	public Person getPerson(String person_id) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "select * from Person where p_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(person_id));
		ResultSet resultSet = preparedStatement.executeQuery();
		Person person = new Person();
		
		while (resultSet.next()) {	
			person.setFirst_name(resultSet.getString(2));
			person.setMiddle_name(resultSet.getString(3));
			person.setLast_name(resultSet.getString(4));
			person.setEmail_address(resultSet.getString(5));
			person.setGender(resultSet.getString(6));
			person.setAddress(resultSet.getString(7));
			person.setCity(resultSet.getString(8));
			person.setState(resultSet.getString(9));
			person.setCountry(resultSet.getString(10));
			person.setZipcode(resultSet.getString(11));
			person.setPhone_number(resultSet.getString(12));
			person.setBank_name(resultSet.getString(13));
			person.setAccount_details(resultSet.getString(14));
			person.setSsn_number(resultSet.getString(15));
		}
		System.out.println(person.getFirst_name());
		return person;
	}

	public void updatePerson(Person person) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "update Person set first_name=?, middle_name=?, last_name=? where email_address=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getFirst_name());
		preparedStatement.setString(2, person.getMiddle_name());
		preparedStatement.setString(3, person.getLast_name());
		preparedStatement.setString(4, person.getEmail_address());
		
		int result = preparedStatement.executeUpdate();
		if(result>0) {
			System.out.println("Person has been updated successfully updated");
		}
	}

	public void deletePerson(String email_address) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "delete from Person where email_address=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email_address);
		int result = preparedStatement.executeUpdate();
		if(result>0) {
			System.out.println("Person has been deleted successfully updated");
		}
	}

	public boolean findPerson(String email_address) throws SQLException {
		boolean isPersonPresent = false;
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "select * from Person where email_address=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email_address);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			String email = resultSet.getString(5);
			if(email.trim().equals(email_address)) {
				isPersonPresent = true;
			}
		}
		return isPersonPresent;
	}
}
