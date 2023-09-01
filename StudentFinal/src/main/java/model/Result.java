package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "result")
public class Result {

    private int student_id;
    private String course_id;
    private String session;
    private String mark;

    public Result() {
    }

    public Result(int student_id, String course_id, String session, String mark) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.session = session;
        this.mark = mark;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Result{" +
                "student_id=" + student_id +
                ", course_id='" + course_id + '\'' +
                ", session='" + session + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
