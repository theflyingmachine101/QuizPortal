package org.base.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select="";
		try{
			select=request.getParameter("select");
		}
		finally
		{
			select="";
		}
		switch(select){
		case "alogin": request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
						break;
		case "asignup":request.getRequestDispatcher("/adminSignup.jsp").forward(request, response);
						break;
		case "ulogin":request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
					  break;
		case "usignup":request.getRequestDispatcher("/userSignup.jsp").forward(request, response);
					  break;
		default: request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	

}