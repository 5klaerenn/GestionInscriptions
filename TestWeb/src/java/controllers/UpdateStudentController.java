/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DaoImp.PersonDAOImplementation;
import interfaceDao.PersonDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

/**
 *
 * @author Sklaerenn
 */
@WebServlet("/updateStudent")
public class UpdateStudentController extends HttpServlet {
    
    private PersonDao dao = new PersonDAOImplementation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("id"));
        
        // Fetch the student's information from the database using dao.findById(studentId)
        Person student = dao.findById(studentId);
        
        request.setAttribute("student", student);
        request.getRequestDispatcher("updateStudent.jsp")
                .forward(request, response);
    }
}