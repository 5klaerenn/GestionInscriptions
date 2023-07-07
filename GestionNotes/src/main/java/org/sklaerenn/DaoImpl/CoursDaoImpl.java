package org.sklaerenn.DaoImpl;

import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.DaoInterface.CoursDao;
import org.sklaerenn.model.Cours;

import java.sql.*;
import java.util.*;

public class CoursDaoImpl implements CoursDao {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Cours c) throws SQLException {

        String createQuery = "INSERT INTO cours(coursId, nomCours) " +
                "VALUES (?,?)";

        PreparedStatement ps = connection.prepareStatement(createQuery);
        ps.setString(1, c.getCoursId());
        ps.setString(2, c.getNomCours());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Cours findById(String coursId) throws SQLException {

        String findByIdQuery = "SELECT * FROM cours " +
                "WHERE coursId = ? ";
        PreparedStatement ps = connection.prepareStatement(findByIdQuery);
        ps.setString(1, coursId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return new Cours(
                rs.getString(1),
                rs.getString(2));
    }

    @Override
    public List<Cours> findAll() throws SQLException {
        List<Cours> coursList = new ArrayList<>();

        String findAllQuery = "SELECT * FROM cours";
        PreparedStatement ps = connection.prepareStatement(findAllQuery);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Cours c = new Cours(
                    rs.getString(1),
                    rs.getString(2));
            coursList.add(c);
        }

        return coursList;
    }

    @Override
    public void update(Cours c) throws SQLException {

        String updateQuery = "UPDATE cours " +
                "SET nomCours = ? " +
                "WHERE coursId = ?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setString(1, c.getNomCours());
        ps.setString(2, c.getCoursId());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void delete(String coursId) throws SQLException {

        String deleteQuery = "DELETE FROM cours "+
                "WHERE coursId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setString(1, coursId);

        ps.executeUpdate();
        ps.close();
    }
}
