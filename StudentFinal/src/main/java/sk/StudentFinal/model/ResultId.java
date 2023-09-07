package sk.StudentFinal.model;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ResultId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @Column(name = "course_session")
    private String course_session;

    public ResultId() {}

    public ResultId(Student student, Course course, String course_session) {
        this.student = student;
        this.course = course;
        this.course_session = course_session;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCourse_session() {
        return course_session;
    }

    public void setCourse_session(String course_session) {
        this.course_session = course_session;
    }

    @Override
    public String toString() {
        return student.getStudentId() + course.getCourse_id() + course_session;
    }
}

