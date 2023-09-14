package sk.StudentFinal.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import sk.StudentFinal.Service.StudentServiceImpl;
import sk.StudentFinal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class StudentController {
    StudentServiceImpl studentService;
    @Autowired
    public StudentController(StudentServiceImpl studentService){this.studentService = studentService;}

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/students")
    public String afficherTout(Model model) {
        List<Student> studentList = studentService.findAll();
        Collections.sort(studentList, (student1, student2) -> student1.getLastName().compareTo(student2.getLastName()));

        model.addAttribute("students", studentList);
        return "students/list-students";
    }

    @GetMapping("/newstudent")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form-students";
    }

    @GetMapping("/updstudent")
    public String studentUpdateForm(@RequestParam("studentId") int id, Model model) {
        Optional<Student> updstudent = studentService.findById(id);
        model.addAttribute("student", updstudent);
        return "students/form-students";
    }

    @GetMapping("/deletestudent")
    public String deleteStudent(@RequestParam("studentId") int id) {
        studentService.deleteById(id);
        return "redirect:/app/students";
    }


    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student newStudent){
        studentService.save(newStudent);
        return "redirect:/app/students";
    }

    @PostMapping("/update_student")
    public String saveUpdatedStudent(@ModelAttribute("student") Student updstudent){
        studentService.save(updstudent);
        return "redirect:/app/students";
    }

}