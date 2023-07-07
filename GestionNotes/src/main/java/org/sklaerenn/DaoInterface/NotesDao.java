package org.sklaerenn.DaoInterface;

import org.sklaerenn.model.Note;
import java.sql.SQLException;
import java.util.List;

public interface NotesDao {

    void create(Note n) throws SQLException;
    Note findById(String etudantId, String coursId) throws SQLException;
    List<Note> findAll() throws SQLException;
    void update(Note n) throws SQLException;
    void delete(String etudantId, String coursId) throws SQLException;

}
