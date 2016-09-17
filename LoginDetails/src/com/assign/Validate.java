package com.assign;

import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String username) 
     {
      boolean st =true;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/profile_mgt","root","myroot");
         PreparedStatement ps =con.prepareStatement
                             ("select * from work where username=?");
         ps.setString(1, username);
        
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }

}