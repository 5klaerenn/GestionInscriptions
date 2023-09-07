package sk.StudentFinal.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.StudentFinal.Service.CourseServiceImpl;
import sk.StudentFinal.dao.CourseRepository;
import sk.StudentFinal.model.Course;

import java.util.List;

@Controller
@RequestMapping("/app")
public class CourseController {

    private CourseServiceImpl courseService;
    public CourseController(CourseServiceImpl courseService){this.courseService = courseService;}

    private List<Course> courseList;

    @PostConstruct
    public void loadData(){
        courseList = courseService.findAll();
    }

    @GetMapping("/courses")
    public String afficherTout(Model model) {
        model.addAttribute("courses", courseList);
        return "list-courses";
    }


}
