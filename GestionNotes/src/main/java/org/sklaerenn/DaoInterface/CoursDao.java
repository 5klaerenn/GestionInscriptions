package org.sklaerenn.DaoInterface;

import org.sklaerenn.model.Cours;

import java.sql.SQLException;
import java.util.List;

public interface CoursDao {

    void create(Cours c) throws SQLException;
    Cours findById(String coursId) throws SQLException;
    List<Cours> findAll() throws SQLException;
    void update(Cours c) throws SQLException;
    void delete(String coursId) throws SQLException;

}
