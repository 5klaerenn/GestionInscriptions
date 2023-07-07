package org.sklaerenn.DaoImpl;

import org.sklaerenn.DaoInterface.EtudiantDao;
import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.model.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
        return null;
    }

    @Override
    public List<Etudiant> findAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Etudiant e) throws SQLException {

    }

    @Override
    public void delete(String etudantId) throws SQLException {

    }
}
