package org.sklaerenn.DaoImpl;

import org.sklaerenn.DaoInterface.NotesDao;
import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.model.Note;

import java.sql.*;
import java.util.*;

public class NotesDaoImpl implements NotesDao {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Note n) throws SQLException {

        String createQuery = "INSERT INTO notes(etudiantid, coursid, note1, note2) " +
                "VALUES (?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(createQuery);
        ps.setString(1, n.getEtudiantId());
        ps.setString(2, n.getCoursId());
        ps.setInt(3, n.getNote1());
        ps.setInt(4, n.getNote2());
        ps.executeUpdate();
        ps.close();

    }

    @Override
    public Note findById(String etudantId, String coursId) throws SQLException {
        String findByIdQuery = "SELECT * FROM notes " +
                "WHERE etudiantId = ? " +
                "AND coursId = ?";
        PreparedStatement ps = connection.prepareStatement(findByIdQuery);
        ps.setString(1, etudantId);
        ps.setString(2, coursId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return new Note(
                rs.getString(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4));
    }

    @Override
    public List<Note> findAll() throws SQLException {
        List<Note> noteList = new ArrayList<>();

        String findAllQuery = "SELECT * FROM notes";
        PreparedStatement ps = connection.prepareStatement(findAllQuery);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Note n = new Note(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4));
            noteList.add(n);
        }
        return noteList;    }

    @Override
    public void update(Note n) throws SQLException {

        String updateQuery = "UPDATE notes " +
                "SET note1 = ?, " +
                "note2 = ?" +
                "WHERE etudiantID = ? " +
                "AND coursId = ?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setInt(1, n.getNote1());
        ps.setInt(2, n.getNote2());
        ps.setString(3, n.getEtudiantId());
        ps.setString(4, n.getCoursId());

        ps.executeUpdate();
        ps.close();

    }

    @Override
    public void delete(String etudiantId, String coursId) throws SQLException {
        String deleteQuery = "DELETE FROM notes " +
                "WHERE etudiantId = ? " +
                "AND coursId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setString(1, etudiantId);
        ps.setString(2, coursId);

        ps.executeUpdate();
        ps.close();

    }
}
