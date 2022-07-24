package demo;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/dbconnection")
public class MYSQLDBConnectionServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
	  Connection con=null;
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      out.println("Servlet Program for Database Connection");
     try {
    	
    	Class.forName("com.mysql.cj.jdbc.driver");
    	out.println("Driverclass loaded");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3307/epproject?useSSL=false","root","sanDeep1@N");
    	
    	out.println("Connection established succesfully");
    	
    	
    	
     }
     catch(Exception e) {
    	 out.println(e);
     }
  }
}