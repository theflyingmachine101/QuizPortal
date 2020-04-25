package org.base.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.base.entities.QuizInfo;
import org.base.entities.QuizQuestion;
import org.base.entities.UserUser;
import org.base.models.QuizModel;
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
		case "showallquiz":	showAllQuiz(request,response);
						break;
		case "takequiz":takeQuiz(request,response);
						break;
		default: request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}


	private void showAllQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QuizInfo> quiz= new QuizModel().showAllQuiz(dataSource);
		Collections.sort(quiz, new Comparator<QuizInfo>(){
		    public int compare(QuizInfo q1, QuizInfo q2) {
		        return   q1.getQname().compareToIgnoreCase(q2.getQname());
		    }
		});
		request.setAttribute("quiz",quiz);
		request.getRequestDispatcher("/userPage/showQuizzes.jsp").forward(request, response);
	}
	
	
	private void takeQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("reqQuiz", new QuizInfo(Integer.parseInt(request.getParameter("qid")), 
				Integer.parseInt(request.getParameter("aid")), 
				request.getParameter("qname")));
		List<QuizQuestion> quizDetail=new QuizModel().showQuizQuestion(dataSource,Integer.parseInt(request.getParameter("qid")));
		request.setAttribute("quizDetail",quizDetail);
		request.getRequestDispatcher("/userPage/showQuizDetail.jsp").forward(request, response);
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
		case "getresult": getResult(request,response);
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
				request.getSession().invalidate();
				HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(300);
			    newSession.setAttribute("currentuser", reUser.getUname());
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
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("currentuser",request.getParameter("userName"));
			response.sendRedirect(request.getContextPath()+"/User?select=options");
	
}
	
	
	private void getResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<QuizQuestion> quizDetail=new QuizModel().showQuizQuestion(dataSource,Integer.parseInt(request.getParameter("qid")));
		int attempted=0,score=0,totalScore=0;
		for(int l=0;l<quizDetail.size();++l)
		{
			String check=request.getParameter(new Integer(l).toString());
			QuizQuestion currentQuestion=quizDetail.get(l);
			if(check!=null)
			{
				int answer=currentQuestion.getAnswer();
				if(check.equals(new Integer(answer).toString()))
				{
					score+=currentQuestion.getMm();
				}
				else
				{
					score+=currentQuestion.getNm();
				}
				totalScore+=currentQuestion.getMm();
				attempted++;
			}
		}
		float accuracy= ( new Integer(score).floatValue())/(new Integer(totalScore).floatValue());
		accuracy*=100;
		request.setAttribute("quizDetail",quizDetail);
		request.setAttribute("totalquestion", quizDetail.size());
		request.setAttribute("score",score);
		request.setAttribute("totalScore",totalScore);
		request.setAttribute("attempted",attempted);
		request.setAttribute("accuracy",accuracy);
		request.setAttribute("qname",request.getParameter("qname"));
		request.getRequestDispatcher("/userPage/answer.jsp").forward(request, response);
	}

}
