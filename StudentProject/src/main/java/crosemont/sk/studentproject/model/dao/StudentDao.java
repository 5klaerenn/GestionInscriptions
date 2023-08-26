package crosemont.sk.studentproject.model.dao;

import crosemont.sk.studentproject.model.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);
    void update(Student student);
    void delete(int id);
    List<Student> findAll();
    Student findById(int id);

}
