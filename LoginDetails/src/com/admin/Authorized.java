package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authorized
 */
@WebServlet("/Authorized")
public class Authorized extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        
        if(username.equals("admin")&&(Validate.checkUser(username, password)))      
        {
            RequestDispatcher rs = request.getRequestDispatcher("change.html");
            rs.forward(request, response);
        }
         else
        {
        	out.println("Your are not Authorized Person");
           RequestDispatcher rs = request.getRequestDispatcher("admin.html");
           rs.include(request, response);
        }
    }  
}