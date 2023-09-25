/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DaoImp.PersonDAOImplementation;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.PersonService;

import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 *
 * @author Sklaerenn
 */

@Controller
@RequestMapping("/student")
public class CoursController extends HttpServlet {

    @Autowired
    PersonDAOImplementation dao;
    @Autowired
    private PersonService personService;

    @GetMapping
    public String showStudents(Model model) {
        List<Person> students = personService.getAllPersons();
        model.addAttribute("students", students);
        return "student";
    }

    @GetMapping("/update")
    public String updateStudent(@RequestParam("id") int studentId, Model model) {
        Person student = personService.getPersonById(studentId);
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName) {
        Person newPerson = new Person(firstName, lastName);
        personService.createPerson(newPerson);
        return "redirect:/student";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam("id") int id,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        Person personToUpdate = new Person();
        personToUpdate.setId(id);
        personToUpdate.setFirstName(firstName);
        personToUpdate.setLastName(lastName);
        personService.updatePerson(personToUpdate);
        return "redirect:/student";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id) {
        personService.deletePerson(id);
        return "redirect:/student";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>S


}
