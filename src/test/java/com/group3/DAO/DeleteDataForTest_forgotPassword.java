package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class DeleteDataForTest_forgotPassword {
	
	Connection con;
	PreparedStatement stat;
	String query;
	
	public void deleteDataFromDbForTest(String MAIL_ID)
	{
		try
		{
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "delete from AUTHENTICATION_DATABASE where MAIL_ID = ?";
			
			stat = con.prepareStatement(query);
			stat.setString(1, MAIL_ID);
		
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
