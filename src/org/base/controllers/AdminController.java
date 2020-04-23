package org.base.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.base.entities.AdminUser;
import org.base.models.AdminUserModel;

@WebServlet("/Admin")
public class AdminController extends HttpServlet {
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
		case "options":request.getRequestDispatcher("/adminPage/adminOptions.jsp").forward(request,response);
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
		case "adminlogin":searchUser(request,response);							
						 break;
		case "adminsignup":addUser(request,response);
		 				   break;
		default: request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
	
	
	
	
	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	AdminUser reUser=new AdminUserModel().searchUser(dataSource,request.getParameter("adminEmail"));
	
	String adminPassword=request.getParameter("adminPassword");
	
			if(reUser==null)
			{
				response.sendRedirect(request.getContextPath()+"/Home?select=asignup");
			}
			else if(adminPassword.equals(reUser.getApassword()))
			{
				request.getSession().invalidate();
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(300);
			    newSession.setAttribute("currentuser", reUser.getAname());
				response.sendRedirect(request.getContextPath()+"/Admin?select=options");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/Home?select=alogin");
			}

	}
	
	
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	new AdminUserModel().addUser(dataSource, new AdminUser(request.getParameter("adminName"),
			request.getParameter("adminEmail"),
			request.getParameter("adminPassword")));
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("currentuser",request.getParameter("adminName"));
			response.sendRedirect(request.getContextPath()+"/Admin?select=options");
	
}

}
