package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class UserPasswordDAO implements IUserPasswordDAO{
	Connection con;
	PreparedStatement stat;
	String query;
	
	public boolean isUserExist(String email)
	{
		//return true if email already exists and return false otherwise...!!!
		
		boolean res=false;
		ResultSet result = null;
		try 
		{
			
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "SELECT * FROM AUTHENTICATION_DATABASE WHERE MAIL_ID = ?";
			
			stat = con.prepareStatement(query);
			stat.setString(1, email);
		
			result = stat.executeQuery();
			
			
			System.out.println();
			res=result.next();
			con.close();


		} 
		catch (SQLException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
	
	
	public void updateNewPassword(String email,String password)
	{
		
		//update the password for given email
		try 
		{
			
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "update AUTHENTICATION_DATABASE set PASSWORD = ? where MAIL_ID = ?";
			
			stat = con.prepareStatement(query);
			stat.setString(1, password);
			stat.setString(2, email);
		
			int count = stat.executeUpdate();
			System.out.println(count+" records updated...!!!");
			con.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
