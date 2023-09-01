package sk.StudentFinal.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ResultId implements Serializable {

    private int student;
    private String  course;
    private String session;

    public ResultId(int student, String course, String session) {
        this.student = student;
        this.course = course;
        this.session = session;
    }

    public ResultId() {

    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
