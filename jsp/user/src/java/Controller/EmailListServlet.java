package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Model.User;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sklaerenn
 */
public class EmailListServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request,
                            HttpServletResponse response)
                            throws ServletException, IOException {
        
        String url = "/index.html";
        
        //get current action
        String action = request.getParameter("action");
        if(action == null){
            action = "join"; //default action
        }
        
        //perform action and set URSL to appropriate page
        if(action.equals("display")){
            url = "/index.html"; //the "join" page
        } else if (action.equals("add")) {
            //get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            //store data in User object and save User object in db
            User user = new User(firstName, lastName, email);
            //UserDB.insert(user);

            
            //set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp"; //the "thanks" page
        }
        
        //forward request and response objects to specified URL 
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
