package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    private String course_id;
    private String course_name;
    private int credits;

    public Course() {
    }

    public Course(String course_id, String course_name, int credits) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credits = credits;
    }

    @Id
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Column(name = "course_name")
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Column(name = "credits")
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
