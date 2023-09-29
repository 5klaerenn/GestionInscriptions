package sk.StudentFinal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "credits")
    private int credits;

    public Course() {
    }

    public Course(String courseId, String course_name, int credits) {
        this.courseId = courseId;
        this.course_name = course_name;
        this.credits = credits;
    }


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + courseId + '\'' +
                ", course_name='" + course_name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
