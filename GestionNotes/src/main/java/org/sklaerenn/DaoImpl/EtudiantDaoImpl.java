package org.sklaerenn.DaoImpl;

import org.sklaerenn.DaoInterface.EtudiantDao;
import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.model.Etudiant;

import java.sql.*;
import java.util.*;


public class EtudiantDaoImpl implements EtudiantDao {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Etudiant e) throws SQLException {

        String createQuery = "INSERT INTO etudiants(etudiantid, nom, prenom) " +
                "VALUES (?,?,?)";

        PreparedStatement ps = connection.prepareStatement(createQuery);
        ps.setString(1, e.getEtudiantId());
        ps.setString(2, e.getNom());
        ps.setString(3, e.getPrenom());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Etudiant findById(String etudantId) throws SQLException {
        String findByIdQuery = "SELECT * FROM etudiants " +
                "WHERE etudiantId = ? ";
        PreparedStatement ps = connection.prepareStatement(findByIdQuery);
        ps.setString(1, etudantId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return new Etudiant(
                rs.getString(2),
                rs.getString(3));
    }

    @Override
    public List<Etudiant> findAll() throws SQLException {

        List<Etudiant> etuList = new ArrayList<>();

        String findAllQuery = "SELECT * FROM etudiants";
        PreparedStatement ps = connection.prepareStatement(findAllQuery);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Etudiant e = new Etudiant(
                    rs.getString(2),
                    rs.getString(3));
            etuList.add(e);
        }
        return etuList;
    }

    @Override
    public void update(Etudiant e) throws SQLException {

        String updateQuery = "UPDATE etudiants " +
                "SET nom = ?, " +
                "prenom = ?" +
                "WHERE etudiantID = ?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setString(1, e.getNom());
        ps.setString(2, e.getPrenom());
        ps.setString(3, e.getEtudiantId());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void delete(String etudiantId) throws SQLException {

        String deleteQuery = "DELETE FROM etudiants " +
                "WHERE etudiantId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setString(1, etudiantId);

        ps.executeUpdate();
        ps.close();

    }
}
