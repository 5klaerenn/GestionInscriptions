/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.util.logging.Logger;
import DaoImp.PersonDAOImplementation;
import interfaceDao.PersonDao;
import java.io.IOException;
import java.util.logging.Level;
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
    
    private static final Logger logger = Logger.getLogger(UpdateStudentController.class.getName());
    private PersonDao dao = new PersonDAOImplementation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("id"));
        
        // Fetch the student's information from the database using dao.findById(studentId)
        Person student = dao.findById(studentId);
                logger.info("update réussi");

        request.setAttribute("student", student);
        request.getRequestDispatcher("updateStudent.jsp")
                .forward(request, response);
        
    }
    
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // Create a new Person object with updated information
        Person updatedStudent = new Person();
        updatedStudent.setId(studentId);
        updatedStudent.setFirstName(firstName);
        updatedStudent.setLastName(lastName);

        // Update student information in the database
        dao.update(updatedStudent);

        // Redirect back to the index page
        response.sendRedirect(request.getContextPath() + "/student");
    }

    @Override
        public void init() throws ServletException {
            super.init();
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.INFO);
        }

}