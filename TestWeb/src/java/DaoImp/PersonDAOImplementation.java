package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.PersonDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class PersonDAOImplementation implements PersonDao{
    
    Connection connection = ConnectionFactory.getConnection();

    // Constructor 
    public PersonDAOImplementation() {

    }

    // Create a new Person
    public void create(Person person) {

        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO PERSON(id, name) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            
            preparedStatement.setString(1, person.getId());
            preparedStatement.setString(2, person.getName());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find by id
    @Override
    public Person findById(String id) {

        Person person = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM person where id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            person = new Person();
            person.setId(resultSet.getString("id"));
            person.setName(resultSet.getString("name"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return person;
    }

    // find All people
    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();
        Person person = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM PERSON ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getString("id"));
                person.setName(resultSet.getString("name"));
                persons.add(person);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return persons;
    }

    // Update person's info
    public void update(Person person) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE PERSON SET NAME = ? WHERE ID = ?";
            //System.out.println("Query = " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete person
    public void delete(String id) {

        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM PERSON WHERE ID =" + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
