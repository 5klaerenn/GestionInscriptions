package org.sklaerenn.model;

public class Cours {

    private int coursId;
    private String nomCours;

    public Cours(int coursId, String nomCours) {
        this.coursId = coursId;
        this.nomCours = nomCours;
    }

    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
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
        return "Cours{" +
                "coursId=" + coursId +
                ", nomCours='" + nomCours + '\'' +
                '}';
    }
}
