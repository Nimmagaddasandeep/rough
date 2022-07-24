package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import demo.DBConnection;

@WebServlet("/checkuserlogin")
public class CheckUserLoginServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String uid=request.getParameter("uid");
      String upwd=request.getParameter("upwd");

      
      try
      {
        Connection con = DBConnection.getConnection();
      
        PreparedStatement pstmt = con.prepareStatement("select * from userregistration where username=? and password=?");
        
        pstmt.setString(1, uid);
        pstmt.setString(2, upwd);
        
          ResultSet rs = pstmt.executeQuery();
          if(rs.next())
          {
           response.sendRedirect("userhome.html");
          }
          else
          {
            response.sendRedirect("userlogin.html");
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