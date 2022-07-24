package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import demo.DBConnection;

@WebServlet("/expense")
public class UserExpenseServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String userid=request.getParameter("userid");
      String Entersalary=request.getParameter("Enter salary");
      String Wages=request.getParameter("Wages");
      String commissions=request.getParameter("commissions");
      String Repairandmaintenance=request.getParameter("Repair and maintenance");
      String Rent=request.getParameter("Rent");
      String Utilities=request.getParameter("Utilities");
      String Bankcharges=request.getParameter("Bankcharges");
      
      
      try
      {
        Connection con = DBConnection.getConnection();
        
    PreparedStatement pstmt = con.prepareStatement(" insert into expense(userid,Enter salary,wages,commissions,Repair and maintenance,Rent,Utilities,Bankcharges) values(?,?,?,?,?,?,?,?) ");
       pstmt.setString(1,userid); 
       pstmt.setString(2,Entersalary); 
       pstmt.setString(3,Wages); 
       pstmt.setString(4,commissions); 
       pstmt.setString(5,Repairandmaintenance); 
       pstmt.setString(6,Rent); 
       pstmt.setString(7,Utilities); 
       pstmt.setString(7,Bankcharges); 
     
       
       int n = pstmt.executeUpdate();
       
       if(n>0)
       {
         out.println("User Expenses");
       }
       else
       {
         out.println("Fail to enter");
       }
       pstmt.close();
       con.close();
    
      }
      catch(Exception e)
      {
        out.println(e);
      }
      
  }
}