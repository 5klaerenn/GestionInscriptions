/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author Sklaerenn
 */
public class Etudiant {
    
    private int id;
    private String nom;
    private String prenom;
    
    public Etudiant(int i, String n, String p){
        this.id = i;
        this.nom = n;
        this.prenom = p;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "\n" + id + " - " + prenom + " " + nom;
    }
    
    
    
    

}
