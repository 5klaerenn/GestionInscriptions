package sk.StudentFinal.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "result")
public class Result implements Serializable {

    @EmbeddedId
    private ResultId id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                                CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "student_id", referencedColumnName = "student_id",
                    insertable = false, updatable = false)
    private Student student;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",
                            insertable = false, updatable = false)
    private Course course;


    @Column(name = "mark")
    private Double mark;

    public Result() {
    }

    public Result(ResultId id, Double mark) {
        this.id = id;
        this.mark = mark;
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

    public ResultId getId() {
        return id;
    }

    public void setId(ResultId id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", mark=" + mark +
                '}';
    }
}
