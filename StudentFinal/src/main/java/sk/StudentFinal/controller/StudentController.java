package sk.StudentFinal.controller;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import sk.StudentFinal.Service.StudentServiceImpl;
import sk.StudentFinal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class StudentController {
    StudentServiceImpl studentService;
    @Autowired
    public StudentController(StudentServiceImpl studentService){this.studentService = studentService;}

    private List<Student> studentList;

    @PostConstruct
    private void loadData(){
        studentList = studentService.findAll();
    }

    @GetMapping("/student")
    public String afficherTout(Model model) {
        model.addAttribute("students", studentList);
        return "list-students";
    }

}