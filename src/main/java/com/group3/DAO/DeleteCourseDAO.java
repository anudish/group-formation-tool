package com.group3.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class DeleteCourseDAO implements IDeleteCourseDAO {

	@Override
	public String deleteCourse(Course course) {
		String deleteQueryGeneration = "delete from COURSES WHERE COURSE_ID = ? ";
		String feedBackMessage;
		try {
			System.out.println(course.getCourseId());
			PreparedStatement preparedstatement = ObtainDataBaseConnection.obtainDatabaseConnection().prepareStatement(deleteQueryGeneration);
		    preparedstatement.setString(1, course.getCourseId());
		    int rowsEffected =  preparedstatement.executeUpdate();
		    System.out.println(rowsEffected);
		    if(rowsEffected == 1) {
		    	feedBackMessage = course.getCourseName()+" ("+course.getCourseId()+") "+" is deleted sucessfully ";
		    }
		    else {
		    	
		    	feedBackMessage = "Error occured while deleting the course";
		    }
		} catch (SQLException e) {
			feedBackMessage = "Server not responding";  
			e.printStackTrace();
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
		return feedBackMessage;
	}

}
