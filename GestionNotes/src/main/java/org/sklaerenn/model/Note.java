package org.sklaerenn.model;

public class Note {

    private int etudiantId;
    private int coursId;
    private int note1;
    private int note2;

    public Note(int etudiantId, int coursId) {
        this.etudiantId = etudiantId;
        this.coursId = coursId;
    }

    public Note(int etudiantId, int coursId, int note1, int note2) {
        this.etudiantId = etudiantId;
        this.coursId = coursId;
        this.note1 = note1;
        this.note2 = note2;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
        this.coursId = coursId;
    }

    public int getNote1() {
        return note1;
    }

    public void setNote1(int note1) {
        this.note1 = note1;
    }

    public int getNote2() {
        return note2;
    }

    public void setNote2(int note2) {
        this.note2 = note2;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "etudiantId=" + etudiantId +
                ", coursId=" + coursId +
                ", note1=" + note1 +
                ", note2=" + note2 +
                '}';
    }
}

