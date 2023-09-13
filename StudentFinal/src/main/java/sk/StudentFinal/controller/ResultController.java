package sk.StudentFinal.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.StudentFinal.Service.CourseServiceImpl;
import sk.StudentFinal.Service.ResultServiceImpl;
import sk.StudentFinal.Service.StudentServiceImpl;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Result;
import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class ResultController {

    private ResultServiceImpl resultService;
    private StudentServiceImpl studentService;
    private CourseServiceImpl courseService;

    @Autowired
    public ResultController(ResultServiceImpl resultService,
                            StudentServiceImpl studentService,
                            CourseServiceImpl courseService){
        this.resultService = resultService;
        this.studentService = studentService;
        this.courseService = courseService;
    }


    @GetMapping("/results")
    public String afficherTout(Model model){
        List<Result> resultList = resultService.findAll();
        model.addAttribute("results", resultList);
        return "results/list-results";
    }

    @GetMapping("/results_student")
    public String afficherNoteEtu(@RequestParam("studentId") int id, Model model){
        Optional<Student> student = studentService.findById(id);

        List<Result> resultList = resultService.getResultByStudentId(id);
        model.addAttribute("results", resultList);
        model.addAttribute("student", student.get());
        return "results/list-results";
    }







}
