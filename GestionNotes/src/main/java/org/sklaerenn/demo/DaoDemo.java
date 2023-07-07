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
        NotesDao notesDao = new NotesDaoImpl();

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
//        Cours c1 = new Cours("420-A34-RO", "Approf. bases de données");
//        Cours c2 = new Cours("420-977-RO", "Structure de données");
//        Cours c3 = new Cours("420-994-RO", "UI/UX");
//        coursDao.create(c1);
//        coursDao.create(c2);
//        coursDao.create(c3);

//        Note n1 = new Note("DORJ", "420-A34-RO", 67, 83);
//        Note n2 = new Note("DORJ", "420-977-RO", 88, 92);
//        Note n3 = new Note("DORJ", "420-994-RO", 72, 95);
//        notesDao.create(n1);
//        notesDao.create(n2);
//        notesDao.create(n3);

        List<Note> noteList = notesDao.findAll();
        for(Note n : noteList){
            System.out.println(n);
        }

        System.out.println("******TEST CONSTRUCTEUR 2 PARAMS******");
        Note n4 =  new Note("COXP", "420-A34-RO");
//        notesDao.create(n4);

        noteList = notesDao.findAll();
        for(Note n : noteList){
            System.out.println(n);
        }

        n4.setNote1(44);
        notesDao.update(n4);
        System.out.println(notesDao.findById("COXP", "420-A34-RO"));

        System.out.println();
        n4.setNote2(78);
        notesDao.update(n4);
        System.out.println(notesDao.findById("COXP", "420-A34-RO"));

        notesDao.delete("COXP", "420-A34-RO");
        System.out.println();
        noteList = notesDao.findAll();
        for(Note n : noteList){
            System.out.println(n);
        }


    }
}