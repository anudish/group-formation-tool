package com.group3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class AddCourseDAO implements IAddCourseDAO {

	@Override
	public String addCourse(Course course)  {
		// TODO Auto-generated method stub
	
		String insertCourseNameQuery ="INSERT "+" INTO "+"COURSES"+ " (COURSE_ID,COURSE_NAME) "+" values(?,?); ";
		java.sql.Connection connect =    ObtainDataBaseConnection.obtainDatabaseConnection();
		String CourseId = course.getCourseID();
		String CourseName = course.getCourseName(); 
		
		String feedBackMessage = new String();
		
	    try {
			PreparedStatement prepareinsertCourseQuery = connect.prepareStatement(insertCourseNameQuery);
			prepareinsertCourseQuery.setString(1, CourseId);
			prepareinsertCourseQuery.setString(2, CourseName);
			int rowsEffected = prepareinsertCourseQuery.executeUpdate();
			if(rowsEffected > 0 ) {
				
				
				feedBackMessage = CourseName + " with "+CourseId+" created successfully";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			feedBackMessage = "Course already exist !";
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
	    return feedBackMessage;
	}

	@Override
	public String isCourseExist(String courseId) {
		// TODO Auto-generated method stub
		
		String feedBackMessage = new String();
		
		System.out.println("ID : "+courseId);
	    String selectQuery = "select * from COURSES WHERE COURSE_ID = ?";
	    try {
			PreparedStatement preparedSQLStatement = ObtainDataBaseConnection.obtainDatabaseConnection().prepareStatement(selectQuery);
		    preparedSQLStatement.setString(1, courseId);
			ResultSet rs  = preparedSQLStatement.executeQuery();
			 
			while(rs.next()) {
				
				if(rs.getString(1).equals(courseId)) {
					feedBackMessage = "Course Name  "+rs.getString("COURSE_NAME")+" with "+"Course ID "+rs.getString("COURSE_ID")+" already exists !! ";
					return feedBackMessage;
				}
			}
			
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
		return feedBackMessage;
	}
		
		
	}


