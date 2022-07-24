package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import demo.DBConnection;

@WebServlet("/checkadmin")
public class CheckAdminServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String aid=request.getParameter("aid");
      String apwd=request.getParameter("apwd");

      
      try
      {
        Connection con = DBConnection.getConnection();
      
        PreparedStatement pstmt = con.prepareStatement("select * from admin where aid=? and apwd=?");
        
        pstmt.setString(1, aid);
        pstmt.setString(2, apwd);
        
          ResultSet rs = pstmt.executeQuery();
          if(rs.next())
          {
           response.sendRedirect("adminhome");
          }
          else
          {
            response.sendRedirect("adminlogin.html");
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