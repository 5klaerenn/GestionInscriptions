package org.sklaerenn.demo;

import org.sklaerenn.DaoImpl.*;
import org.sklaerenn.DaoInterface.*;
import org.sklaerenn.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoDemo {
    public static void main(String[] args) throws SQLException {

        CoursDao coursDao = new CoursDaoImpl();
        EtudiantDao etuDao = new EtudiantDaoImpl();
        NotesDao notesDao = new NotesDaoImpl();




    }

    public void menuPrincipal(){

        boolean exit = false;
        int choix;

        while(!exit) {
            System.out.println("************MENU PRINCIPAL************");
            System.out.println("1. Étudiant");
            System.out.println("2. Cours");
            System.out.println("3. Notes");
            System.out.println("4. Sortir");

            choix = estEntierPositif();

            switch (choix) {
                case 1:
                    subEtudiant();
                    break;
                case 2:
                    subCours();
                    break;
                case 3:
                    subNotes();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Merci !");
                    break;
                default:
                    System.out.println("Option invalide. Réessayez");
                    break;
            }
    }

    }

    public void subEtudiant(){

        boolean exit = false;
        int choix;

        while(!exit){
            System.out.println("************MENU ÉTUDIANT************");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les étudiants");
            System.out.println("3. Rechercher un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Mettre à jour un étudiant");
            System.out.println("6. Retour au menu principal");

            choix = estEntierPositif();

        //switch (choix)

        }

    }
    public void subCours(){

    }
    public void subNotes(){

    }

    static int estEntierPositif() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            while(sc.hasNextInt()) {
                int test = sc.nextInt();
                if (test >= 0) {
                    return test;
                }
            }

            System.out.println("Erreur, entrez un entier positif");
            sc.next();
        }
    }

}