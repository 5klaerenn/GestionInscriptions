package org.sklaerenn.demo;

import org.sklaerenn.DaoImpl.*;
import org.sklaerenn.DaoInterface.*;
import org.sklaerenn.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDemo {
    public static void main(String[] args) throws SQLException {

        CoursDao coursDao = new CoursDaoImpl();
        EtudiantDao etuDao = new EtudiantDaoImpl();

        Etudiant e1 = new Etudiant("Snorkel", "Bob");
        etuDao.create(e1);



    }
}