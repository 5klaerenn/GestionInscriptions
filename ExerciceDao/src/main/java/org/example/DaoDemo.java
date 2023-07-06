package org.example;

import jdk.swing.interop.SwingInterOpUtils;
import org.model.Person;
import org.interfaceDao.PersonDAO;

import java.sql.SQLException;
import java.util.List;

public class DaoDemo {
    public static void main(String[] args) throws SQLException {

        PersonDAO dao = new PersonDAOImpl();

        //Création d'entrées dans la table :

        Person p1 = new Person(1, "Kelso");
        Person p2 = new Person(2, "Dorian");
        Person p3 = new Person(3, "Cox");
        Person p4 = new Person(4, "Turk");
        Person p5 = new Person(5, "Espinoza");

        dao.create(p1);
        dao.create(p2);
        dao.create(p3);
        dao.create(p4);
        dao.create(p5);

        System.out.println("**********PREMIER AFFICHAGE**********");
        List<Person> personList = dao.findAll();
        for(Person p : personList){
            System.out.println(p);
        }

        System.out.println("**********RECHERCHE PAR ID**********");
        System.out.println("Exemple 1 (id 1) : " + "\t" + dao.findById(1));
        System.out.println("Exemple 2 (id 5) : " + "\t" + dao.findById(5));


        System.out.println("**********UPDATE DE LA LISTE**********");

        Person p6 = new Person(1, "Reid");
        dao.update(p6);

        System.out.println("**********LISTE MISE À JOUR**********");

        personList = dao.findAll();
        for(Person p : personList){
            System.out.println(p);
        }


        System.out.println("**********SUPPRESSION**********");
        dao.delete(1);

        System.out.println("**********LISTE MISE À JOUR**********");
        personList = dao.findAll();
        for(Person p : personList){
            System.out.println(p);
        }


    }
}