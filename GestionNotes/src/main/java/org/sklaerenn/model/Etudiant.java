package org.sklaerenn.model;

public class Etudiant {

    private int etudiantId;
    private String nom;
    private String prenom;

    public Etudiant(int id, String nom, String prenom) {
    	this.etudiantId = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return  etudiantId +
                " - " + prenom +
                " " + nom;
    }
}
