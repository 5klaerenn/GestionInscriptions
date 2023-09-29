package sk.StudentFinal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.StudentFinal.dao.StudentRepository;
import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements GenericService<Student, Integer> {

    private StudentRepository sRepo;
    @Autowired
    public StudentServiceImpl(StudentRepository sRepo){this.sRepo = sRepo;}

    @Override
    public Optional<Student> findById(Integer id) {

        Optional<Student> result = sRepo.findById(id);
        Student student;

        if (result.isPresent()){
            student = result.get();
        } else {
            throw new RuntimeException("Did not find student id - " + id);
        }

        return Optional.of(student);
    }

    @Override
    public List<Student> findAll() {
        return sRepo.findAll();
    }

    @Override
    public void save(Student student) {
        sRepo.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        sRepo.deleteById(id);
    }

}
