package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class InstructorHandlerDAO implements IInstructorHandlerDAO {
    private Connection connect;
    private  ArrayList<String> courseList;
	public InstructorHandlerDAO() {
    	
    	connect = ObtainDataBaseConnection.obtainDatabaseConnection();
    	courseList = new ArrayList<>();
    }
	@Override
	public String createNewInstructor(String MailId, String CourseId) {
		// TODO Auto-generated method stub
		String feedbackMessage = new String();
		// TODO Auto-generated method stub
		 String SQLInstructorAllocaterQuery = "INSERT INTO ALLOCATE_INSTRUCTOR(MAIL_ID,COURSE_ID) VALUES(?,?)";
		 PreparedStatement preparestatement;
		try {
			preparestatement = connect.prepareStatement(SQLInstructorAllocaterQuery);
			preparestatement.setString(1, MailId);
			 preparestatement.setString(2,CourseId);
			 int rowsEffected = preparestatement.executeUpdate();
			 if(rowsEffected > 0 ) {
				 
				 feedbackMessage = "Instructor Assigned for "+ CourseId;
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return feedbackMessage;
		
	}

	@Override
	public boolean isInstructorExists(String MailId) {
		// TODO Auto-generated method stub
		String SQLSelectQuery = "select * from ALLOCATE_INSTRUCTOR where MAIL_ID = ?";
		PreparedStatement preparestatement;
		try {
			preparestatement = ObtainDataBaseConnection.obtainDatabaseConnection().prepareStatement(SQLSelectQuery);
			preparestatement.setString(1,MailId);
			boolean state = preparestatement.execute();
			return state;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public String deleteinstructor(String MailId) {
		String feedBackMessage = new String();
		// TODO Auto-generated method stub
		String deleteinstructorQuery = "DELETE FROM ALLOCATE_INSTRUCTOR WHERE MAIL_ID = ?";
		PreparedStatement preparestatement;
		try {
			preparestatement = connect.prepareStatement(deleteinstructorQuery);
			 preparestatement.setString(1,MailId);
		   	    int rowsEffected = preparestatement.executeUpdate();
		   	   if(rowsEffected > 0) {
		   		  
		   		  
		   		  feedBackMessage = "Instructor deleted";
		   	  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	   
		return feedBackMessage;
	}
	@Override
	public ArrayList<String> getInstructorCourses(String MailId) {
		// TODO Auto-generated method stub
		String SQLSelectQuery = "select * from ALLOCATE_INSTRUCTOR where MAIL_ID = ?";
		PreparedStatement preparestatement;
		try {
			preparestatement = ObtainDataBaseConnection.obtainDatabaseConnection().prepareStatement(SQLSelectQuery);
			preparestatement.setString(1,MailId);
			ResultSet result = preparestatement.executeQuery();
			while(result.next()) {
				
				courseList.add(result.getString("COURSE_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

}
