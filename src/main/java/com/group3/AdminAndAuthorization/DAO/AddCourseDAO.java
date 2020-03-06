package com.group3.AdminAndAuthorization.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.AdminAndAuthorization.DAO.IAddCourseDAO;
import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class AddCourseDAO implements IAddCourseDAO {
	Connection connection;
	String query;
	PreparedStatement statement;

	private static Logger logger = LogManager.getLogger(AddCourseDAO.class);

	@Override
	public String addCourse(Course course) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");	
		String courseId;
		String courseName;
		String feedBackMessage = new String();
		int rowsEffected;

		query = "INSERT " + " INTO " + "COURSES" + " (COURSE_ID,COURSE_NAME) " + " values(?,?); ";
		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
		courseId = course.getCourseId();
		courseName = course.getCourseName();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, courseId);
			statement.setString(2, courseName);

			rowsEffected = statement.executeUpdate();
			if (rowsEffected > 0) {
				feedBackMessage = courseName + " with " + courseId + " created successfully";
			}
		}

		catch (SQLException e) {
			
			logger.log(Level.WARN,e.getMessage() + " The SQLState is : " + e.getSQLState() + ". Error Code : " + e.getErrorCode());
			feedBackMessage = "Course already exist !";
		}

		finally {
			ObtainDataBaseConnection.terminateConnection();

		}

		return feedBackMessage;
	}

	@Override
	public String isCourseExist(String courseId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");	
		ResultSet resultSet;
		String feedBackMessage = new String();
		query = "select *from COURSES WHERE COURSE_ID = ?";

		try {
			statement = ObtainDataBaseConnection.obtainDatabaseConnection().prepareStatement(query);
			statement.setString(1, courseId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString(1).equals(courseId)) {
					feedBackMessage = "Course Name  " + resultSet.getString("COURSE_NAME") + " with " + "Course ID "
							+ resultSet.getString("COURSE_ID") + " already exists !! ";
					return feedBackMessage;
				}
			}
		}

		catch (SQLException e) {
			logger.log(Level.WARN,e.getMessage() + " The SQLState is : " + e.getSQLState() + ". Error Code : " + e.getErrorCode());
		}finally {
			ObtainDataBaseConnection.terminateConnection();
		}

		return feedBackMessage;
	}
}