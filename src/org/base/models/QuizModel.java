package org.base.models;

import java.sql.Connection;
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
	

}
