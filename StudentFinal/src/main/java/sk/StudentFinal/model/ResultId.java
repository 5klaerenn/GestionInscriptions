package sk.StudentFinal.model;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ResultId implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private String course_id;

    @Column(name = "course_session")
    private String course_session;

    public ResultId() {}

    public ResultId(int studentId, String course_id, String course_session) {
        this.studentId = studentId;
        this.course_id = course_id;
        this.course_session = course_session;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int student_id) {
        this.studentId = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_session() {
        return course_session;
    }

    public void setCourse_session(String course_session) {
        this.course_session = course_session;
    }

    @Override
    public String toString() {
        return studentId + course_id + course_session;
    }
}

