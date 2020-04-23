package org.base.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.base.entities.UserUser;

public class UserUserModel {
	public void addUser(DataSource dataSource, UserUser user) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String username = user.getUname();
			String email = user.getUemail();
			String password =user.getUpassword();
			String query = "insert into userinfo (uname,uemail,upassword) values (?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
		public UserUser searchUser(DataSource dataSource,  String email) {
			UserUser reUser=null;
	        Connection connect = null;
	        Statement stmt = null;
	        ResultSet rs = null;       
	        try {
				connect = dataSource.getConnection();			
				String query = "Select * from userinfo where uemail="+"\""+email+"\"";
				stmt = connect.createStatement();
	         rs = stmt.executeQuery(query);
	         rs.next();
				reUser=new UserUser(rs.getInt("id"),rs.getString("uname"), rs.getString("uemail"), rs.getString("upassword"));	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return reUser;
		}

}
