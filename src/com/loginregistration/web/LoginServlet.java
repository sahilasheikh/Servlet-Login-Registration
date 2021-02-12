package com.loginregistration.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginregistration.dao.User_DAO;
import com.loginregistration.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("/Welcome.html").include(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUser_email(email);
		user.setUser_password(password);
		
		boolean valid = User_DAO.validateUser(user);
		
		if (valid) {
			
			out.print("<p align=\"center\">You are successfully logged in!</p>");  
            out.print("<p align=\"center\"><br>Welcome, your email is " + email + "<br></p>"); 
            out.print("<p align=\"center\"><a href=\"LogoutServlet\">Logout</a></p>");
			
			Cookie ck = new Cookie("email", email);		//invoking cookie to verify the login
			response.addCookie(ck);
			
		} else {
			out.println("<p align=\"center\">email or password error</p>");
			request.getRequestDispatcher("/index.html").include(request, response);
		}
		
		
		
	}

}
