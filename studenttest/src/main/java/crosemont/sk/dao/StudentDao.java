package crosemont.sk.dao;

import crosemont.sk.model.Student;
import org.hibernate.SessionFactory;

import java.util.List;

public interface StudentDao {

    Student getById(int id);
    List<Student> getAll();
    void save(Student student);
    void update(Student student);
    void delete(int id);

}
