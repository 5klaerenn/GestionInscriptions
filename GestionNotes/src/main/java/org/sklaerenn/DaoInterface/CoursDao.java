package org.sklaerenn.DaoInterface;

import org.sklaerenn.model.Cours;

import java.sql.SQLException;
import java.util.List;

public interface CoursDao {

    void create(Cours c) throws SQLException;
    Cours findById(int coursId) throws SQLException;
    List<Cours> findAll() throws SQLException;
    void update(Cours c) throws SQLException;
    void delete(int coursId) throws SQLException;

}
