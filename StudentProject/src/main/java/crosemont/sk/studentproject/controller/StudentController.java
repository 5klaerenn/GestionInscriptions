package crosemont.sk.studentproject.controller;

import crosemont.sk.studentproject.model.dao.StudentDaoImpl;
import crosemont.sk.studentproject.model.entity.Student;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {

    StudentDaoImpl dao;

    @Override
    public void init(){
        dao = new StudentDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("x"));
        String action = request.getParameter("act");

        if(action.equals("delete")){
            dao.delete(id);

            List<Student> listStudents = dao.findAll();
            request.setAttribute("x", listStudents);
            getServletContext().getRequestDispatcher("/personList.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";

        String action = request.getParameter("action");
        if(action == null) {
            action = "join";
        }

        if(action.equals("join")){
            url = "/index.html";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            Student student = new Student(firstName, lastName, email);
            request.setAttribute("student", student);
            url = "/reponse.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}