package org.mouni;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 import java.lang.ClassNotFoundException;
import java.sql.*;
public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(Validate.checkUser(username,password ))
        {
            RequestDispatcher rs = request.getRequestDispatcher("work.html");
            rs.forward(request, response);
        }
        else
        {
        	out.println("username or password is incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
    }  
}