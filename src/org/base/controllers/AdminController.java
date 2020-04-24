package org.base.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.base.entities.AdminUser;
import org.base.entities.QuizInfo;
import org.base.entities.QuizQuestion;
import org.base.models.AdminUserModel;
import org.base.models.QuizModel;


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
		case "showquiz":showQuiz(request,response);
						break;
		case "showquizdetail":showQuizDetail(request,response);
							 break;
		case "createquiz":
							break;
		default: request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}


	private void showQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminUser reUser=new AdminUserModel().searchUser(dataSource,(String)(request.getSession().getAttribute("currentuser")));
		
		List<QuizInfo> quiz=new QuizModel().showQuiz(dataSource,reUser.getId());
		request.setAttribute("AdminQuiz",quiz);
		request.getRequestDispatcher("/adminPage/showQuizzes.jsp").forward(request, response);
	}
	
	private void showQuizDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<QuizQuestion> quizDetail=new QuizModel().showQuizQuestion(dataSource,Integer.parseInt(request.getParameter("qid")));
		request.setAttribute("quizDetail",quizDetail);
		request.setAttribute("quizName",(String)request.getParameter("quizName"));
		request.getRequestDispatcher("/adminPage/showQuizDetail.jsp").forward(request, response);
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
			    newSession.setAttribute("currentuser", reUser.getAemail());
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
			newSession.setAttribute("currentuser",request.getParameter("adminEmail"));
			response.sendRedirect(request.getContextPath()+"/Admin?select=options");
	
}

}
