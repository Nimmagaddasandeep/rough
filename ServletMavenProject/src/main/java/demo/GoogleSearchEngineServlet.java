package demo;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;



@WebServlet("/googlesearch")
public class GoogleSearchEngineServlet extends HttpServlet{
	public void init() {
		System.out.println("Servlet is Initialized");
	}
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		
		String keyword=request.getParameter("txt");
		response.sendRedirect("https://www.google.com/search?q="+keyword);
		
		
		
		
	}
	public void destroy() {
		System.out.println("servlet is destroyed");
	}
	
	
}