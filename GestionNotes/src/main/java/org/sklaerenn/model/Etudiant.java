package org.sklaerenn.model;

public class Etudiant {

    private String etudiantId;
    private String nom;
    private String prenom;

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.etudiantId = nom.substring(0, 3) + prenom.charAt(0);
    }

    public String getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(String etudiantId) {
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
        return "Etudiant{" +
                "etudiantId=" + etudiantId +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
