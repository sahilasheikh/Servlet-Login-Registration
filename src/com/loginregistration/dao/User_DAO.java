package com.loginregistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.loginregistration.model.User;	

public class User_DAO {
	
//	method to get connection
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
//	method to get the maximum user id from the database
	
//	method to stored all the details form the registration form into database
	public static int registerUser(User user) {
		int i = 0;
		int id = 0;
		try {
			Connection con = User_DAO.getConnection();
			PreparedStatement ps_max = con.prepareStatement("select max(id) from loginregister001");
			ResultSet rs = ps_max.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);		//selecting the max id from the database.
				id++;					//increasing the max id by one to create a unique primary key.
				
				PreparedStatement ps = con.prepareStatement("insert into loginregister001 values(?,?,?,?,?,?,?)");
				ps.setInt(1, user.getUser_id());
				ps.setString(2, user.getUser_name());
				ps.setString(3, user.getUser_email());
				ps.setString(4, user.getUser_password());
				ps.setLong(5, user.getUser_contact_number());
				ps.setString(6, user.getUser_dob());
				ps.setString(7, user.getUser_gender());
				
				i = ps.executeUpdate();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to validate the user for login
	public static boolean validateUser(User user) {
		boolean validate = false;
		try {
			Connection con = User_DAO.getConnection();
			
			String username = user.getUser_email();
			String password = user.getUser_password();
			
			PreparedStatement ps = con.prepareStatement("select * from loginregister001 where email = ? and password = ?");		//here we are selecting the record (if exists) from the database whose email and password is given.
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			validate = rs.next();		//if record exists then the user is validate.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validate;
	}
	
}
