package org.base.models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.base.entities.AdminUser;

public class AdminUserModel {
	public void addUser(DataSource dataSource,  AdminUser user) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String username = user.getAname();
			String email = user.getAemail();
			String password =user.getApassword();
			String query = "insert into admininfo (aname,aemail,apassword) values (?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
		public AdminUser searchUser(DataSource dataSource,  String email) {
			AdminUser reUser=null;
	        Connection connect = null;
	        Statement stmt = null;
	        ResultSet rs = null;       
	        try {
				connect = dataSource.getConnection();			
				String query = "Select * from admininfo where aemail="+"\""+email+"\"";
				stmt = connect.createStatement();
	         rs = stmt.executeQuery(query);
	         rs.next();
				reUser=new AdminUser(rs.getInt("id"),rs.getString("aname"), rs.getString("aemail"), rs.getString("apassword"));	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return reUser;
		}
}
