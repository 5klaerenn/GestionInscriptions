package sk.StudentFinal.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.StudentFinal.Service.CourseServiceImpl;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class CourseController {

    private CourseServiceImpl courseService;
    public CourseController(CourseServiceImpl courseService){this.courseService = courseService;}

    @GetMapping("/courses")
    public String afficherTout(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courses", courseList);
        return "courses/list-courses";
    }

    @GetMapping("/newcourse")
    public String courseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/form-courses";
    }

    @GetMapping("/updatecourse")
    public String courseUpdateForm(@RequestParam("course_id") String id, Model model) {
        Optional<Course> course = courseService.findById(id);
        model.addAttribute("course", course);
        return "courses/form-updatecourses";
    }

    @GetMapping("/deletecourse")
    public String deleteStudent(@RequestParam("course_id") String id) {
        courseService.deleteById(id);
        return "redirect:/app/courses";
    }

    @PostMapping("/courses")
    public String saveStudent(@ModelAttribute("course") Course newCourse){
        courseService.save(newCourse);
        return "redirect:/app/courses";
    }

    @PostMapping("/update_course")
    public String saveUpdatedStudent(@ModelAttribute("course") Course updcourse){
        courseService.save(updcourse);
        return "redirect:/app/courses";
    }


}
