/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import dao.EtudiantDAO;
import model.Etudiant;
import java.util.ArrayList;

/**
 *
 * @author Sklaerenn
 */
public class EtudiantDaoImp implements EtudiantDAO {
    
    static ArrayList<Etudiant> etudiants;
    
    public EtudiantDaoImp() {
        etudiants = new ArrayList<Etudiant>(); 
        Etudiant etu1 = new Etudiant(1, "Kelso", "Bob");
        Etudiant etu2 = new Etudiant(2, "Cox", "Perry");
        Etudiant etu3 = new Etudiant(3, "Dorian", "John");
        
        etudiants.add(etu1);
        etudiants.add(etu2);
        etudiants.add(etu3);
    }
    
    public void create(Etudiant e){
        etudiants.add(e);
    }
    
    public void update(Etudiant e){
        int id = e.getId();
        String nom = e.getNom();
        String prenom = e.getPrenom();
        
        int indice = matchId(id);
        
        etudiants.get(indice).setNom(nom);
        etudiants.get(indice).setPrenom(prenom);
    }
    
    public void delete(int id){
        etudiants.remove(matchId(id));
    }

    @Override
    public Etudiant findById(int id) {
        return etudiants.get(matchId(id));
    }

    @Override
    public ArrayList<Etudiant> findAll() {
        return etudiants;
    }
    
    public static int matchId(int id){
        
        boolean trouve = false;
        int indice = 0;
        int i = 0;
        
        while(i < etudiants.size() && !trouve){
            if (id == etudiants.get(i).getId()) {
                indice = i; 
                trouve = true;
            } 
            i++; 
        }
        
        if(!trouve){
            System.out.println("Cet id n'existe pas dans la liste");
        }
        
        return indice;
        
    }
       
}
