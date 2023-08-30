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


public class PersonDAOImplementation implements PersonDao{
    
    Connection connection = ConnectionFactory.getConnection();

    // Constructor 
    public PersonDAOImplementation() {

    }

    // Create a new Person
    public void create(Person person) {

        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO PERSON(firstName, lastName) VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(createQuery, new String[]{"id"});

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                person.setId(generatedId);  // Set the generated ID in the Person object
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }
    }
        
    @Override
    public Person findById(int id) {
        
        Person person = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

    try {
        String selectIdQuery = "SELECT * FROM person WHERE id = ?";
        preparedStatement = connection.prepareStatement(selectIdQuery);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setFirstName(resultSet.getString("firstName"));
            person.setLastName(resultSet.getString("lastName"));
        }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return person;
    }
    
    @Override
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
            person.setId(resultSet.getInt("id"));
            person.setFirstName(resultSet.getString("firstName"));
            person.setLastName(resultSet.getString("lastName"));
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
            String updateQuery = "UPDATE PERSON SET firstName = ?, lastName = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete person
    public void delete(int id) {

        PreparedStatement preparedStatement;
        
        try {
            String deleteQuery = "DELETE FROM PERSON WHERE ID = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
