package org.interfaceDao;

import org.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {

    void create(Person p) throws SQLException;
    Person findById(int id) throws SQLException;
    List<Person> findAll() throws SQLException;
    void update(Person p) throws SQLException;
    void delete(int id) throws SQLException;

}
