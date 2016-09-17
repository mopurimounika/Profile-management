package com.mouni;

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
@WebServlet("/Password")
public class Password extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/profile_mgt";;
String username = "root";
String password = "myroot";

String Username = request.getParameter("username");
String Password = request.getParameter("Newpassword");
String Conform  = request.getParameter("Conform password");
if(Password.equals(Conform))
{
	out.println("password successfully changed");
	RequestDispatcher rs = request.getRequestDispatcher("password.html");
    rs.include(request, response);
	
}
else
{
	out.println("password doesn't matches");
	RequestDispatcher rs = request.getRequestDispatcher("pass.html");
    rs.include(request, response);
}
String query = "UPDATE login SET password ='"+Password+"'WHERE username='"+Username+"'";
showTable(driver, url, username, password, query, out);

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


