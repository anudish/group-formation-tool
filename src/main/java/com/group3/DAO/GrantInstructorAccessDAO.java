package com.group3.DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.*;

import com.group3.BusinessModels.GuestModel;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class GrantInstructorAccessDAO implements IGrantInstructorAccessDAO {
	GuestModel guestmodel;
	ArrayList<GuestModel> userHolder;
	public GrantInstructorAccessDAO(){
		
		userHolder = new ArrayList<>();
	}
	@Override
	public ArrayList<GuestModel> returnEligibleUsersList() {
		// TODO Auto-generated method stub
		String SQLQueryStatement = "select * From "+ "USER_DATABASE" +" where ROLE = ? OR ROLE = ? ";
		
		 
		Connection connect = ObtainDataBaseConnection.obtainDatabaseConnection();
		try {
			PreparedStatement preparestatement = connect.prepareStatement(SQLQueryStatement);
			//Only newly registered user or Granted Instructor can be eligible for obtaining role of Instructor
			preparestatement.setString(1, "GUEST");
			preparestatement.setString(2,"INSTRUCTOR");
			ResultSet resultset = preparestatement.executeQuery();
			
		    if(resultset.next()==false) {
		    	System.out.println("No Instructor or guest users");
		    	
		    }
		    else {
		    	
		    	resultset.previous();
		    	while(resultset.next()) {
		    		guestmodel = new GuestModel();
		    		guestmodel.setFirstName(resultset.getString("FIRST_NAME"));
		    		guestmodel.setLastName(resultset.getString("LAST_NAME"));
		    		guestmodel.setEmail(resultset.getString("MAIL_ID"));
		    		guestmodel.setUserRole(resultset.getString("ROLE"));
		    		
		    		userHolder.add(guestmodel);
		    	}
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
		
		return userHolder;
	}

}
