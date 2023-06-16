/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cours1;

import dao.EtudiantDaoImp;
import dao.EtudiantDAO;
import model.Etudiant;
import java.util.Scanner;
import view.ViewMenu;

/**
 *
 * @author Sklaerenn
 */
public class Etudiants {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ViewMenu menu = new ViewMenu();
        menu.setVisible(true);


        EtudiantDAO dao = new EtudiantDaoImp();
//        
//        System.out.println("----------LISTE INITIALE----------");
//        System.out.println(dao.findAll());
//
//        dao.create(new Etudiant(4, "Reid", "Eliott"));
//        
//        System.out.println("--------- CREATE ----------");
//        System.out.println(dao.findAll());
//
//        dao.update(new Etudiant(2, "Turkelton", "Turk"));
//        
//        System.out.println("--------- UPDATE ----------");
//        System.out.println(dao.findAll());
//
//        dao.delete(2);
//        
//        System.out.println("--------- DELETE ----------");
//        System.out.println(dao.findAll());
//        
//        System.out.println("--------- FIND BY ID ----------");
//        System.out.println(dao.findById(2));
        
        boolean logged = true;
        int choix = 0;
        
        
        do{
            
            choix = menu();
            
            switch (choix) {
                case 1:
                    dao.create(nouveauEtu());
                    break;
                case 2:
                    dao.update(nouveauEtu());
                    break;
                case 3: 
                    System.out.println("Quel est l'id de l'étudiant que vous voulez supprimer ?");
                    dao.delete(recherche());
                    break;
                case 4:
                    System.out.println(dao.findAll());
                    break;
                case 5:
                    System.out.println("Quel est l'id de l'étudiant à rechercher ? ");
                    System.out.println(dao.findById(recherche()));
                    break;
                case 6:
                    logged = false;
                    break;
                default:
                    throw new AssertionError();
            }

        } while(logged);
       
        
    }
    
    public static int menu(){
               
        System.out.println("-----------MENU-----------");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Modifier un étudiant");
        System.out.println("3. Supprimer un étudiant");
        System.out.println("4. Afficher les étudiants");
        System.out.println("5. Rechercher un étudiant");
        System.out.println("6. Quitter");
        
        int choix = estEntierPositif() ;
        
        while(choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5 && choix != 6){
            System.out.println("Erreur. Les choix possibles sont 1, 2, 3, 4, 5 ou 6. Réessayez");
            choix = estEntierPositif();
        }
        
        return choix ;
        
    }
    
    public static Etudiant nouveauEtu(){
        Etudiant etu;
        Scanner sc = new Scanner(System.in); 
        int id;
        String nom, prenom;
                
        System.out.println("Entrez l'id de l'étudiant");
        id = estEntierPositif();
        
        System.out.println("Entrez le nom de l'étudiant");
        nom = sc.nextLine();
        
        System.out.println("Entrez le prenom de l'étudiant");
        prenom = sc.nextLine();
        
        return etu = new Etudiant(id, nom, prenom);      
    }
    
    public static int recherche(){
        int rep;
        return rep = estEntierPositif();
    }

    public static int estEntierPositif(){    
    
        Scanner sc = new Scanner(System.in);
        int test;
               
        do{
            while(!sc.hasNextInt()){
                System.out.println("Erreur, entrez un entier positif");
                sc.next();
            } test = sc.nextInt();
        } while (test < 0);
               
        return test;
    }
    
}
