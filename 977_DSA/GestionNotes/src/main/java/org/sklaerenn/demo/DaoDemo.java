package org.sklaerenn.demo;

import org.sklaerenn.DaoImpl.*;
import org.sklaerenn.DaoInterface.*;
import org.sklaerenn.model.*;

import java.sql.SQLException;
import java.util.*;


public class DaoDemo {
    public static void main(String[] args) throws SQLException {

        CoursDao coursDao = new CoursDaoImpl();
        EtudiantDao etuDao = new EtudiantDaoImpl();
        NotesDao notesDao = new NotesDaoImpl();

        menuPrincipal(coursDao, etuDao, notesDao);

    }

    public static void menuPrincipal(CoursDao coursDao, EtudiantDao etuDao, NotesDao notesDao) throws SQLException{

        boolean exit = false;
        int choix;

        while(!exit) {
            System.out.println("************MENU PRINCIPAL************");
            System.out.println("1. Étudiant");
            System.out.println("2. Cours");
            System.out.println("3. Notes");
            System.out.println("4. Quitter");

            choix = estEntierPositif();

            switch (choix) {
                case 1:
                    subEtudiant(etuDao);
                    break;
                case 2:
                    subCours(coursDao);
                    break;
                case 3:
                    subNotes(notesDao);
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

    //Sous-menu pour la gestion des étudiants
    public static void subEtudiant(EtudiantDao etuDao) throws SQLException{

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

        switch (choix) {
        	case 1 : 
        		etuDao.create(newStudent());
        		break;
        	case 2 :
        		System.out.println(etuDao.findAll());
        		break;
        	case 3 : 
        		System.out.println("Entrez l'id de l'étudiant à rechercher : ");
        		System.out.println(etuDao.findById(estEntierPositif()));
        		break;
        	case 4 : 
        		System.out.println("Entrez l'id de l'étudiant à supprimer : ");
        		etuDao.delete(estEntierPositif());
        		break;
        	case 5 : 
        		etuDao.update(newStudent());
        		break;
        	case 6 : 
                exit = true;
                break;
            default:
                System.out.println("Option invalide. Réessayez");
                break; 
        }

        }

    }
    
    // Sous-menu pour la gestion des cours
    
 public static void subCours(CoursDao coursDao) throws SQLException{
    	
    	Scanner sc = new Scanner(System.in);
    	String id;
    	boolean exit = false;
        int choix;

        while(!exit){
            System.out.println("************MENU COURS************");
            System.out.println("1. Ajouter un cours");
            System.out.println("2. Afficher tous les cours");
            System.out.println("3. Rechercher un cours");
            System.out.println("4. Supprimer un cours");
            System.out.println("5. Mettre à jour un cours");
            System.out.println("6. Retour au menu principal");

            choix = estEntierPositif();

	        switch (choix) {
	        	case 1 : 
	        		coursDao.create(nouveauCours());
	        		break;
	        	case 2 :
	        		System.out.println(coursDao.findAll());
	        		break;
	        	case 3 : 
	        		System.out.println("Entrez l'id du cours à rechercher : ");
	        		id = sc.nextLine().toUpperCase();
	        		System.out.println(coursDao.findById(id));
	        		break;
	        	case 4 : 
	        		System.out.println("Entrez l'id du cours à supprimer : ");
	        		id = sc.nextLine().toUpperCase();
	        		coursDao.delete(id);
	        		break;
	        	case 5 : 
	        		coursDao.update(nouveauCours());
	        		break;
	        	case 6 : 
	                exit = true;
	                break;
	            default:
	                System.out.println("Option invalide. Réessayez");
	                break; 
	        }
        }
        
        
    }
    
    // Sous-menu pour la gestion des notes 
    public static void subNotes(NotesDao notesDao) throws SQLException{
    	Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int choix, etuId;
        String coursID;

        while(!exit){
            System.out.println("************MENU NOTES************");
            System.out.println("1. Ajouter une note");
            System.out.println("2. Afficher toutes les notes");
            System.out.println("3. Rechercher les notes d'un étudiant");
            System.out.println("4. Supprimer une note");
            System.out.println("5. Modifier une note");
            System.out.println("6. Retour au menu principal");

            choix = estEntierPositif();

	        switch (choix) {
	        	case 1 : 
	        		notesDao.create(nouvelleNote());
	        		break;
	        	case 2 :
	        		System.out.println(notesDao.findAll());
	        		break;
	        	case 3 : 
	        		System.out.println("Entrez l'id de l'étudiant à rechercher : ");
	        		etuId = estEntierPositif();
	        		System.out.println("Entrez l'id du cours à rechercher : ");
	        		coursID = sc.nextLine().toUpperCase();
	        		
	        		System.out.println(notesDao.findById(etuId, coursID));
	        		break;
	        	case 4 : 
	        		System.out.println("Entrez l'id de l'étudiant à rechercher : ");
	        		etuId = estEntierPositif();
	        		System.out.println("Entrez l'id du cours à rechercher : ");
	        		coursID = sc.nextLine().toUpperCase();	        		
	        		notesDao.delete(etuId,coursID);
	        		break;
	        	case 5 : 
	        		notesDao.update(nouvelleNote());
	        		break;
	        	case 6 : 
	                exit = true;
	                break;
	            default:
	                System.out.println("Option invalide. Réessayez");
	                break; 
	        }

        }

    }
    
    public static Etudiant newStudent() {
        Scanner sc = new Scanner(System.in); 
		int id;
		String nom, prenom;
			
			System.out.println("Entrez l'ID de l'étudiant : ");
			id = estEntierPositif();
			
			System.out.println("Entrez le prenom de l'étudiant : ");
			prenom = sc.nextLine();
			
			System.out.println("Entrez le nom de l'étudiant : ");
			nom = sc.nextLine();
						
			Etudiant e = new Etudiant(id, nom, prenom);
			return e;
    }
    
    public static Cours nouveauCours() {
    	Scanner sc = new Scanner(System.in); 
    	String coursId, nomCours;
    	
    	System.out.println("Entrez l'ID du cours : ");
    	coursId = sc.nextLine().toUpperCase();
    	
    	System.out.println("Entrez le nom du cours : ");
    	nomCours = sc.nextLine();
    	    	
    	Cours c = new Cours(coursId, nomCours);
    	return c;
    }
    
    public static Note nouvelleNote() {
    	Scanner sc = new Scanner(System.in); 
        int etudiantId, note1, note2;
        String coursId;
        
    	
        System.out.println("Entrez l'ID de l'étudiant : ");
        etudiantId = sc.nextInt();
        
    	System.out.println("Entrez l'ID du cours : ");
    	coursId = sc.next().toUpperCase();
    	
    	System.out.println("Entrez la première note : ");
    	note1 = sc.nextInt();
    	
    	System.out.println("Entrez la deuxième note : ");
    	note2 = sc.nextInt();
   	
    	Note n = new Note(etudiantId, coursId, note1, note2);
    	return n;
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