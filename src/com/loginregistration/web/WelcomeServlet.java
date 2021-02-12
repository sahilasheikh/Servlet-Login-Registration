package com.loginregistration.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
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
		
		Cookie cookie[] = request.getCookies();
		if (cookie != null) {
			String email = cookie[0].getValue();
			if (!email.equals("") || email != null) {
				out.print("<p align=\"center\"><b>Welcome to Profile</b></p>");  
	            out.print("<p align=\"center\"><br>Welcome, "+ email + "</p>");
	            out.print("<p align=\"center\"><a href=\"LogoutServlet\">Logout</a></p>");
			}
		} else {
			out.print("<p align=\"center\">Please login first</p>");
            request.getRequestDispatcher("index.html").include(request, response);
		}
		
	}

}
