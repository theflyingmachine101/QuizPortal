package org.base.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.base.entities.UserUser;
import org.base.models.UserUserModel;


@WebServlet("/User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select=request.getParameter("select");
		select=select.toLowerCase();
		
		if(select==null)
			select="";
		
		switch(select)
		{
		case "options":request.getRequestDispatcher("/userPage/userOptions.jsp").forward(request,response);
						break;
		default: request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String select=request.getParameter("select");
		select=select.toLowerCase();
		
		if(select==null)
			select="";
		
		switch(select)
		{
		case "userlogin":searchUser(request,response);							
						 break;
		case "usersignup":addUser(request,response);
		 				   break;
		default: request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	
	
	
	
	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	UserUser reUser=new UserUserModel().searchUser(dataSource,request.getParameter("userEmail"));
	
	String adminPassword=request.getParameter("userPassword");
	
			if(reUser==null)
			{
				response.sendRedirect(request.getContextPath()+"/Home?select=usignup");
			}
			else if(adminPassword.equals(reUser.getUpassword()))
			{
				response.sendRedirect(request.getContextPath()+"/User?select=options");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/Home?select=ulogin");
			}

	}
	
	
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	new UserUserModel().addUser(dataSource, new UserUser(request.getParameter("userName"),
			request.getParameter("userEmail"),
			request.getParameter("userPassword")));
	response.sendRedirect(request.getContextPath()+"/User?select=options");
	
}

}
