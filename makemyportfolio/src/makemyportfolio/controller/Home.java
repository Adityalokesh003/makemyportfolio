package makemyportfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		//System.out.println(session);
		if(session!=null){
				request.setAttribute("message", session.getAttribute("message"));
				session.removeAttribute("message");
		}
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
