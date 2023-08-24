package crosemont.sk.demohibernate.dao;

import crosemont.sk.demohibernate.model.Student;
import java.util.List;

public interface StudentDao {

    Student get(int id);
    List<Student> getAll();
    void create(Student student);
    void update(Student student);
    void delete(int id);
}
