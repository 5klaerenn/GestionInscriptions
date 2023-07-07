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

//        Etudiant e1 = new Etudiant("Kelso", "Bob");
//        Etudiant e2 = new Etudiant("Cox", "Perry");
//        Etudiant e3 = new Etudiant("Dorian", "John");
//        Etudiant e4 = new Etudiant("Turkelton", "Turk");
//        Etudiant e5 = new Etudiant("Reid", "Eliott");
//        etuDao.create(e1);
//        etuDao.create(e2);
//        etuDao.create(e3);
//        etuDao.create(e4);
//        etuDao.create(e5);
//




    }
}