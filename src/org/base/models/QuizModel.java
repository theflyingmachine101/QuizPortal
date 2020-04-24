package org.base.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.base.entities.QuizInfo;
import org.base.entities.QuizQuestion;


public class QuizModel {
	public List<QuizInfo> showQuiz(DataSource dataSource,int id)
	{
		Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<QuizInfo> answer=new ArrayList<>();
        try {
			connect = dataSource.getConnection();			
			String query = "Select * from quizinfo where aid="+id;
			stmt = connect.createStatement();
         rs = stmt.executeQuery(query);
         while(rs.next())
         {
        	answer.add(new QuizInfo(rs.getInt("qid"),
        			rs.getInt("aid"),
        			rs.getString("qname")));
         }

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return answer;
	}
	public List<QuizQuestion> showQuizQuestion(DataSource dataSource,int id)
	{
		Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<QuizQuestion> answer=new ArrayList<>();
        try {
			connect = dataSource.getConnection();			
			String query = "Select * from quiz_question where qid="+id;
			stmt = connect.createStatement();
         rs = stmt.executeQuery(query);
         while(rs.next())
         {
        	answer.add(new QuizQuestion(rs.getInt("qid"),
        			rs.getInt("mm"),
        			rs.getInt("nm"),
        			rs.getInt("answer"),
        			rs.getString("question"),
        			rs.getString("option1"),
        			rs.getString("option2"),
        			rs.getString("option3"),
        			rs.getString("option4")
        			));
         }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return answer;
	}
	public QuizInfo createQuiz(DataSource dataSource,int aid,String Qname)
	{
		Connection connect = null;
		PreparedStatement statement = null;
		 Statement stmt = null;
	      ResultSet rs = null;
	      QuizInfo answer=null;
		try {
			connect = dataSource.getConnection();
			String query = "insert into quizinfo (aid,qname) values (?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, aid);
			statement.setString(2,Qname);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {			
			String query = "Select * from quizinfo where qname="+"\""+Qname+"\"";
			stmt = connect.createStatement();
         rs = stmt.executeQuery(query);
         rs.next();
         answer=new QuizInfo(rs.getInt("qid"),rs.getInt("aid"),rs.getString("qname"));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return answer;
	}
	public void addQuestion(DataSource dataSource,int qid,String
			question,String option1,String option2,String option3,String option4,int answer,int mm,int nm)
	{
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "insert into quiz_question (qid,question,option1,option2,option3,option4,answer,mm,nm) values "
					+ "(?,?,?,?,?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setInt(1, qid);
			statement.setString(2, question);
			statement.setString(3, option1);
			statement.setString(4, option2);
			statement.setString(5, option3);
			statement.setString(6, option4);
			statement.setInt(7, answer);
			statement.setInt(8, mm);
			statement.setInt(9, nm);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
