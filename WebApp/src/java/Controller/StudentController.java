/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import model.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sklaerenn
 */
public class StudentController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                            HttpServletResponse response)
                            throws ServletException, IOException {
        
        String url = "/index.html";
//        //forward request and response objects to specified URL 
//        getServletContext()
//                .getRequestDispatcher(url)
//                .forward(request, response);
        
        String action = request.getParameter("action");
        if(action == null){
            action = "join"; //default action
        }

        if(action.equals("join")){
            url = "/index.html"; //the "join" page
        } else if (action.equals("add")) {
            //get parameters from the request
            String name = request.getParameter("name");
            
            //store data in User object and save User object in db
            Person pers = new Person(name);
            //UserDB.insert(user);

            //set User object in request object and set URL
            request.setAttribute("person", pers);
            url = "/display.jsp"; //the "diplay" page
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        

    }

    @Override
    protected void doGet(HttpServletRequest request,
                           HttpServletResponse response)
                           throws ServletException, IOException {
        doPost(request, response);
    }
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
