package sk.StudentFinal.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    @Column(name = "firstname")

    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")

    private String email;
    @Column(name = "city")
    private String City;
    public Student() {
    }

    public Student(int student_id, String firstName, String lastName, String email, String city) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        City = city;
    }

    public Student(String firstName, String lastName, String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        City = city;
    }


    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + student_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
