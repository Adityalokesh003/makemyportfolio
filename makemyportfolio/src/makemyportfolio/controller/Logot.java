package makemyportfolio.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Logot
 */
public class Logot extends HttpServlet {  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println(session);  
		if((session!=null) && (session.getAttribute("user")!=null)){
			System.out.println(); 
			session.invalidate();
			ServletContext servletContext = getServletContext();
			servletContext.setAttribute("lomsg", "<p class='alert alert alert-success'>You are successfully logged out<p>");
		} 
		response.sendRedirect("home");
	}

}
