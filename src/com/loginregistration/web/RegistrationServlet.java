package com.loginregistration.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginregistration.dao.User_DAO;
import com.loginregistration.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException
	, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		getting values from html page
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String re_enter_password = request.getParameter("re_enter_password");
		long number = Long.parseLong(request.getParameter("number"));
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");

//		condition for password and re-enter password
		if (password.equals(re_enter_password)) {
			
			User user = new User();					//creating object for user model class
//			setting all the values to User class
//			user.setUser_id(id);
			user.setUser_name(name);
			user.setUser_email(email);
			user.setUser_password(password);
			user.setUser_contact_number(number);
			user.setUser_dob(dob);
			user.setUser_gender(gender);
			
			int i = User_DAO.registerUser(user);		//invoking the register user method from User_DAO class

//			condition if user is successfully registered or not
			if (i == 1) {
				out.println("<p align=\"center\">You have successfully registered</p>");
				request.getRequestDispatcher("/index.html").include(request, response);
			} else {
				out.println("<p align=\"center\">Your registration is failed please try again</p>");
				request.getRequestDispatcher("/registration.html").include(request, response);
			}
		} else {
			out.println("<p align=\"center\">Password did not match</p>");
			request.getRequestDispatcher("/registration.html").include(request, response);
		}
		
		
		
		
	}

}
