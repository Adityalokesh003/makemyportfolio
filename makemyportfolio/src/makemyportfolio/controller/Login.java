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

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		UserDao userDao = UserDaoFactory.getUserDao();
		boolean isLoggedIn = userDao.login(user_name, password);
		if(isLoggedIn){
			String message = "<p class='alert alert-success'>congradulations " + user_name+"! You are succesfully logged in</p>";
			HttpSession session = request.getSession(true);
			User user = userDao.getByUsername(user_name);
			session.setAttribute("user", user);
			session.setAttribute("message",message );
			response.sendRedirect("home");
		}else{
			if (userDao.getByUsername(user_name)==null) {
				request.setAttribute("error_message", "username is incorrect.");
			}else{
				request.setAttribute("error_message", "password is incorrect.");
			}

			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}


	}

}
