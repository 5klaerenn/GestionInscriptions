package org.sklaerenn.model;

public class Cours {

    private String coursId;
    private String nomCours;

    public Cours(String coursId, String nomCours) {
        this.coursId = coursId;
        this.nomCours = nomCours;
    }

    public String getCoursId() {
        return coursId;
    }

    public void setCoursId(String coursId) {
        this.coursId = coursId;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    @Override
    public String toString() {
        return coursId + " - " + nomCours;
    }
}
