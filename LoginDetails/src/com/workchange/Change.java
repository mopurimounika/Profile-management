package com.workchange;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Password
 */
@WebServlet("/Change")
public class Change extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/profile_mgt";;
String username = "root";
String password = "myroot";

String Username = request.getParameter("username");
String Work = request.getParameter("work");

if( username==username)
{
	String query = "UPDATE work SET work ='"+Work+"'WHERE username='"+Username+"'";
	showTable(driver, url, username, password, query, out);
	out.println("work successfully changed");
	out.println("<title>User</title>");
out.println("<style> thead th { text-align:right; background:#F74F2B; color:white; width:1850px; height:20px}</style>");
out.println("<body><p><table>");
out.println("<thead><tr><th>");
out.println("<font>Profile Management Portal");
out.println("</font></th></tr>");
out.println("</thead></table></p><br><br><br>");
out.println("<div>");
out.println("<h3> <center>work</center></h3>");
out.println("<br>");
out.println("<table border=1 align=center bordercolor= #F74F2B width=50% height=50%>");
out.println("<tr bgcolor=#F74F2B><th>username</th><th>work</th></tr>");
out.println("<tr><td>" + Username + "</td><td>" + Work + "</td></tr>"); 
}
	

else
{
	out.println("username is wrong");
	RequestDispatcher rs = request.getRequestDispatcher("change.html");
    rs.include(request, response);
}


}
public void showTable(String driver, String url, String username, String password, String query, PrintWriter out) {
try {
Class.forName(driver);
Connection connection = DriverManager.getConnection(url, username, password);
Statement statement = connection.createStatement();
int resultSet = statement.executeUpdate(query);
connection.close();
}catch(ClassNotFoundException cnfe) {
System.err.println("Error loading driver: " + cnfe);
}catch(SQLException sqle) {
System.err.println("Error connecting: " + sqle);
} catch(Exception ex) {
System.err.println("Error with input: " + ex);
}
}
}


