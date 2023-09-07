package sk.StudentFinal.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "result")
public class Result implements Serializable {

    @EmbeddedId
    private ResultId id;

    @Column(name = "mark")
    private Double mark;

    public Result() {
    }

    public Result(ResultId id, Double mark) {
        this.id = id;
        this.mark = mark;
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
