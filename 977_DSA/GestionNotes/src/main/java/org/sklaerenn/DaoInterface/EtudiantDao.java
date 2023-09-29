package org.sklaerenn.DaoInterface;

import org.sklaerenn.model.Etudiant;

import java.sql.SQLException;
import java.util.List;

public interface EtudiantDao {

    void create(Etudiant e) throws SQLException;
    Etudiant findById(int etudantId) throws SQLException;
    List<Etudiant> findAll() throws SQLException;
    void update(Etudiant e) throws SQLException;
    void delete(int etudantId) throws SQLException;

}