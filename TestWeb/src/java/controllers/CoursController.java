/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;
import DaoImp.PersonDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;
import java.util.logging.Logger;

/**
 *
 * @author Sklaerenn
 */
@WebServlet({"/student"})
public class CoursController extends HttpServlet {
    
    private static final Logger logger = Logger.getLogger(CoursController.class.getName());
    
    PersonDAOImplementation dao;
    List<Person> students;

    @Override
    public void init() throws ServletException{
       dao = new PersonDAOImplementation();  
       
       super.init();
       Logger logger = Logger.getLogger("");
       logger.setLevel(Level.INFO);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");    
        students = dao.findAll();
        request.setAttribute("students", students);
        
        logger.info("dans le doGet");

        if (action != null && action.equals("update")) {
            logger.info("ICI");
            int studentId = Integer.parseInt(request.getParameter("id"));
            // Fetch the student's information from the database using dao.findById(studentId)
            Person student = dao.findById(studentId);
            request.setAttribute("student", student);
            request.getRequestDispatcher("updateStudent.jsp")
                    .forward(request, response);
        } 
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action != null){
            switch (action) {
                case "add":
                    logger.info("in the add method");

                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");

                    Person newPerson = new Person(firstName, lastName);
                    dao.create(newPerson);
                    logger.info("création réussie");
                    break;

                case "update":   
                    logger.info("in the update method");

                    int id = Integer.parseInt(request.getParameter("id"));
                    String upfirstName = request.getParameter("firstName");
                    String uplastName = request.getParameter("lastName");

                    Person personToUpdate = new Person();
                    personToUpdate.setId(id);
                    personToUpdate.setFirstName(upfirstName);
                    personToUpdate.setLastName(uplastName);

                    dao.update(personToUpdate);

                    // Redirect to updateStudent.jsp for editing student details
                    response.sendRedirect(request.getContextPath() + "/student");
                    return;

                case "delete":
                    logger.info("in the delete method");

                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    break;
            }
        }

        
        logger.info("AAAAAAAARRRRRRRRFFFFFFFFFF");
        response.sendRedirect(request.getContextPath() + "/student"); // Redirect to doGet
        
    
    /*
        List<Person> students = dao.findAll();
        String url = "/index.jsp";

        //get current action
        String action = request.getParameter("action");
        if(action == null){
            action = "join"; //default action
        }

        //perform action and set URSL to appropriate page
        if(action.equals("join")){        
            url = "/index.jsp"; //the "join" page
        } else if (action.equals("add")) {
            //get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            
            //store data in User object and save User object in db
            Person person = new Person(firstName, lastName);
            dao.create(person);
            students.add(person);
            
            //set User object in request object and set URL
            request.setAttribute("students", students);
            url = "/listeEtudiants.jsp"; //the "thanks" page

        } else if(action.equals("afficher")) {
            students = dao.findAll();
            
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            Person personToUpdate = new Person();
            personToUpdate.setId(id);
            personToUpdate.setFirstName(firstName);
            personToUpdate.setLastName(lastName);

            dao.update(personToUpdate);
                      
            // Redirect to updateStudent.jsp for editing student details
            response.sendRedirect("updateStudent?id=" + id);
            //response.sendRedirect("index?action=display");
            return;
        } else if (action.equals("delete")) {
        
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            return;
        }
        
        request.setAttribute("students", students);
        
        //forward request and response objects to specified URL 
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
     */   
    }
     
        
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
