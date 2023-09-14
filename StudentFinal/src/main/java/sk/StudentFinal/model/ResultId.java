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
    private String courseId;

    @Column(name = "course_session")
    private String courseSession;

    public ResultId() {}

    public ResultId(int studentId, String courseId, String courseSession) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseSession = courseSession;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int student_id) {
        this.studentId = student_id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String course_id) {
        this.courseId = course_id;
    }

    public String getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(String course_session) {
        this.courseSession = course_session;
    }

    @Override
    public String toString() {
        return studentId + courseId + courseSession;
    }
}

