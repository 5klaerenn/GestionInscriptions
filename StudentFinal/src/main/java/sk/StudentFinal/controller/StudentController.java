package sk.StudentFinal.controller;
import sk.StudentFinal.Service.StudentServiceImpl;
import sk.StudentFinal.dao.StudentDaoImpl;
import sk.StudentFinal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class StudentController {
    private StudentServiceImpl studServ;

    @Autowired
    public StudentController(StudentServiceImpl studServ) {
        this.studServ = studServ;
    }

    @GetMapping("/student")
    public List<Student> findAll() {
        return studServ.findAll();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        student.setStudentId(0);
        return studServ.create(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        return studServ.update(student);
    }
}