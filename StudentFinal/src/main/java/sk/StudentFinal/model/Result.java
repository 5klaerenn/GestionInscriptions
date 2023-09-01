package sk.StudentFinal.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "result")
public class Result implements Serializable {

    @EmbeddedId
    private ResultId id;

    @MapsId("student")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @MapsId("course")
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private String mark;

    public Result() {
    }

    public Result(ResultId id, String mark) {
        this.id = id;
        this.mark = mark;
    }

    @Column(name = "mark")
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


}
