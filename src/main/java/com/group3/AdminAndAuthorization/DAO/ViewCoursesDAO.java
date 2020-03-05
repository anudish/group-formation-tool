package com.group3.AdminAndAuthorization.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;


public class ViewCoursesDAO implements IViewCoursesDAO {
	ArrayList<Course> allCourses;
	Course course;
	public  ViewCoursesDAO() {
		allCourses = new ArrayList<>();
	}
	@Override
	public ArrayList<Course> getAllCourses() {		
		String SQLQueryForAllCourses = "Select * from COURSES";
		
		Connection connect =  ObtainDataBaseConnection.obtainDatabaseConnection();
		try {
			ResultSet allCoursesSet =  connect.createStatement().executeQuery(SQLQueryForAllCourses);
		    if(allCoursesSet.next() == false) {
		    	return allCourses;
		    	
		    }
		    else {
		    	allCoursesSet.previous();
		    	while(allCoursesSet.next()) {
		    		String courseId = allCoursesSet.getString("COURSE_ID");
		    		String courseName = allCoursesSet.getString("COURSE_NAME");
		    		course = new Course();
		            course.setCourseId(courseId);
		            course.setCourseName(courseName);
		            allCourses.add(course);
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			ObtainDataBaseConnection.terminateConnection();
			
		}
		
		return allCourses;
	
	}

}
