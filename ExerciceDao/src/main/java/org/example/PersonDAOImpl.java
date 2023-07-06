package org.example;

import org.connection.ConnectionFactory;
import org.model.Person;
import org.interfaceDao.PersonDAO;

import java.sql.*;
import java.util.*;


public class PersonDAOImpl implements PersonDAO {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Person p) throws SQLException{
        String query = "INSERT INTO PERSON(id, name) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, p.getId());
        preparedStatement.setString(2, p.getName());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public Person findById(int id)  throws SQLException{

            String query = "SELECT * FROM person " +
                    "WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Person p = new Person(
                    rs.getInt(1),
                    rs.getString(2));

        return p;
    }

    @Override
    public List<Person> findAll() throws SQLException {
        String query = "SELECT * "
                + "FROM person";

        ArrayList<Person> listePers = new ArrayList<Person>();

        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Person pers = new Person(
                    rs.getInt(1),
                    rs.getString(2));

            listePers.add(pers);
        }
        return listePers;
    }

    @Override
    public void update(Person p) throws SQLException {
        String query = "UPDATE person " +
                "SET name = ? " +
                "WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, p.getName());
        ps.setInt(2, p.getId());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM person " +
                "WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();

    }
}
