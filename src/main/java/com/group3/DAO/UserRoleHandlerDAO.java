package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class UserRoleHandlerDAO implements IUserRoleHandlerDAO {
     private Connection connect;
	 public UserRoleHandlerDAO(){
		 connect = ObtainDataBaseConnection.obtainDatabaseConnection();
		 
	 }
	@Override
	public String updateUserRole(String Role, String MaildId) {
		int rowsEffected = 0;
		
		String updateUserRoleQuery = "UPDATE USER_DATABASE SET ROLE =? WHERE MAIL_ID = ? ";
		String feedBackMessage = new String();
		PreparedStatement preparestatement;
		try {
			preparestatement = connect.prepareStatement(updateUserRoleQuery);
			System.out.println(Role);
			preparestatement.setString(1, Role);
			preparestatement.setString(2, MaildId);
			rowsEffected = preparestatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
		
		
		if(rowsEffected > 0) { feedBackMessage = "Role of user is altered to "+ Role;}
		
		return feedBackMessage;
		
	}

	@Override
	public String returnUserRole(String MailId) {
		// TODO Auto-generated method stub
		String Role = new String();
		// TODO Auto-generated method stub
		String returnUserRoleQuery = "SELECT ROLE FROM USER_DATABASE WHERE MAIL_ID=?";
		PreparedStatement preparestatement;
		try {
			preparestatement = ObtainDataBaseConnection.obtainDatabaseConnection().prepareStatement(returnUserRoleQuery);
			preparestatement.setString(1, MailId);
			ResultSet resultset = preparestatement.executeQuery();
			resultset.next();
			 Role = resultset.getString("ROLE");
			return Role;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
		
		return Role;
	}

}
