package sk.StudentFinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.StudentFinal.Service.CourseServiceImpl;
import sk.StudentFinal.Service.ResultServiceImpl;
import sk.StudentFinal.Service.StudentServiceImpl;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Result;
import sk.StudentFinal.model.ResultId;
import sk.StudentFinal.model.Student;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class ResultController {

    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

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
        Collections.sort(resultList, (result1, result2) -> result1.getId().getCourseId().compareTo(result2.getId().getCourseId()));
        model.addAttribute("results", resultList);
        return "results/list-results";
    }

    @GetMapping("/results_student")
    public String afficherNoteEtu(@RequestParam("studentId") int id, Model model){
        Optional<Student> student = studentService.findById(id);

        List<Result> resultList = resultService.getResultByStudentId(id);
        model.addAttribute("results", resultList);
        model.addAttribute("student", student.get());
        return "results/list-results-student";
    }

    @GetMapping("/results_course")
    public String afficherNoteCourse(@RequestParam("courseId") String id, Model model){
        Optional<Course> course = courseService.findById(id);

        List<Result> resultList = resultService.getResultByCourses(id);
        model.addAttribute("results", resultList);
        model.addAttribute("courses", course.get());
        return "results/list-results-course";
    }

    @GetMapping("/add-result")
    public String newResult(Model model){
        model.addAttribute("result", new Result());
        return "results/form-results";
    }


    @PostMapping("/add-result")
    public String saveResult(@ModelAttribute("result") Result newResult){
        resultService.save(newResult);
        return "redirect:/app/results";
    }

    @GetMapping("/add-result-student")
    public String newResultStudent(@RequestParam("studentId") int studentId, Model model){
        Optional<Student> student = studentService.findById(studentId);
        List<Course> courseList = courseService.findAll();

        model.addAttribute("student", student.get());
        model.addAttribute("courseList", courseList);
        model.addAttribute("studentId", studentId);
        model.addAttribute("result", new Result());
        return "results/form-results-student";
    }

    @PostMapping("/add-result-student")
    public String saveResultStudent(@RequestParam("studentId") int studentId,
                        @ModelAttribute("result") Result newResult) {

        logger.debug("Received studentId: {}", studentId);

        newResult.getId().setStudentId(studentId);
        resultService.save(newResult);
        return "redirect:/app/results";
    }

    @GetMapping("/add-result-course")
    public String newResultCourse(@RequestParam("courseId") String courseId,
                                  Model model){

        Optional<Course> course = courseService.findById(courseId);
        List<Student> studentList = studentService.findAll();

        model.addAttribute("course", course.get());
        model.addAttribute("studentList", studentList);
        model.addAttribute("courseId", courseId);
        model.addAttribute("result", new Result());
        return "results/form-results-course";
    }

    @PostMapping("/add-result-course")
    public String saveResultCourse(@RequestParam("courseId") String courseId,
                                    @ModelAttribute("result") Result newResult) {

        logger.debug("Received courseId: {}", courseId);

        newResult.getId().setCourseId(courseId);
        resultService.save(newResult);

        return "redirect:/app/results";
    }

    @GetMapping("/update-result")
    public String updateResultForm(@RequestParam("studentId") int studentId,
                                   @RequestParam("courseId") String courseId,
                                   @RequestParam("session") String courseSession,
                                   Model model) {

        Optional<Student> updstudent = studentService.findById(studentId);
        Optional<Course> updcourse = courseService.findById(courseId);
        ResultId resultId = new ResultId(studentId, courseId ,courseSession);
        Optional<Result> updresult = Optional.ofNullable(resultService.getResultById(resultId));

            model.addAttribute("student", updstudent.orElse(null));
            model.addAttribute("course", updcourse.orElse(null));
            model.addAttribute("session", courseSession);
            model.addAttribute("result", updresult);

        return "results/update-result";

    }

    @PostMapping("/update-result")
    public String saveUpdatedResult(@ModelAttribute("result") Result updresult) {
        resultService.save(updresult);
        return "redirect:/app/results";
    }

    @GetMapping("/delete-result")
    public String deleteResult(@RequestParam("studentId") int studentId,
                                   @RequestParam("courseId") String courseId,
                                   @RequestParam("session") String courseSession,
                                   Model model) {
        ResultId resultId = new ResultId(studentId, courseId, courseSession);
        resultService.deleteById(resultId);
        return "redirect:/app/results";
    }
}
