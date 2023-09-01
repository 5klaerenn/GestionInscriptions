package sk.StudentFinal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.StudentFinal.dao.StudentDaoImpl;
import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements GenericService<Student, Integer> {

    private StudentDaoImpl dao;
    @Autowired
    public StudentServiceImpl(StudentDaoImpl dao){this.dao = dao;}

    @Override
    public Optional<Student> findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<Student> student = dao.findById(id);
        if(student != null){
            dao.delete(student.get().getStudentId());
        }
    }

    @Override
    public Student update(Student student) {
        dao.update(student);
        return student;
    }

    @Override
    public Student create(Student student) {
        dao.create(student);
        return student;
    }
}
