package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class InsertDataForTest_forgorPassword {
	
	Connection con;
	PreparedStatement stat;
	String query;
	
	public void insertDataIntoDbForTest(String MAIL_ID,String PASSWORD)
	{
		try
		{
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "insert into AUTHENTICATION_DATABASE values(?,?)";
			
			stat = con.prepareStatement(query);
			stat.setString(1, MAIL_ID);
			stat.setString(2, PASSWORD);
		
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
	
	public String getDataFromDbForTest(String MAIL_ID)
	{
		ResultSet result;
		String password = null;
		try
		{
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "select *from AUTHENTICATION_DATABASE where MAIL_ID = ?";
			
			stat = con.prepareStatement(query);
			stat.setString(1, MAIL_ID);
		
			result = stat.executeQuery();
			
			System.out.println();
			result.next();
			password = result.getString("PASSWORD");
			con.close();
		}
		catch (SQLException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

}
