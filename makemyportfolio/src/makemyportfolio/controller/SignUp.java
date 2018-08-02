package makemyportfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import makemyportfolio.bo.User;
import makemyportfolio.dao.UserDao;
import makemyportfolio.dao.daofactory.UserDaoFactory;
 
public class SignUp extends HttpServlet {
	public static final long SerialVersionUID=1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		UserDao userDao = UserDaoFactory.getUserDao();
		boolean isSignedUp = userDao.signup(user_name, password);
		if(isSignedUp){
			String message = "<p class='alert alert-success'>congradulations " + user_name+"! You are succesfully signed up</p>";
			HttpSession session = request.getSession(true);
			User user = userDao.getByUsername(user_name);
			session.setAttribute("user", user);
			session.setAttribute("message",message );
			
			response.sendRedirect("home");
		}else{
			request.setAttribute("error_message", "username "+user_name+ " already exists");
			request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
		}
		
	}

}
