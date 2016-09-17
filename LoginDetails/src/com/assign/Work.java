package com.assign;

 import java.io.*;
 import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 import java.sql.*;
 @WebServlet("/Work")
 public class Work extends HttpServlet {
  
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
         PrintWriter out = res.getWriter();
         res.setContentType("text/html");
         out.println("<html><body>");
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/profile_mgt","root","myroot");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM work");
             out.println("<table border=1 align=center bordercolor= #F74F2B width=50% height=50%>");
             out.println("<tr bgcolor=#F74F2B><th>username</th><th>work</th></tr>");
             while (rs.next()) {
                 String username = rs.getString("username");
                 String work = rs.getString("work");
               
                 out.println("<tr><td>" + username + "</td><td>" + work + "</td></tr>"); 
             }
             out.println("</table>");
             out.println("</html></body>");
             con.close();
            }
             catch (Exception e) {
             out.println("error");
         }
     }
 }