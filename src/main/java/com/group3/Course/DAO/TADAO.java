package com.group3.Course.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class TADAO implements ITADAO {
	Connection connection;
	String query;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	Course courseModel;
	ArrayList<Course> courseInfo;

	public ArrayList<Course> getCoursesByTAMailId(String studentMailId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		courseInfo = new ArrayList<Course>();
		try {
			connection = ObtainDataBaseConnection.obtainDatabaseConnection();
			String query = "SELECT C.COURSE_ID, C.COURSE_NAME" + " FROM COURSES C"
					+ " JOIN student_enrollments S ON S.COURSE_ID=C.COURSE_ID" + " WHERE S.MAIL_ID=\"" + studentMailId
					+ "\"";

			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			courseInfo = new ArrayList<Course>();

			while (result.next()) {
				logger.info(result.getObject("COURSE_ID") + ": " + result.getObject("COURSE_NAME"));
				courseModel = new Course();
				courseModel.setCourseId(result.getObject("COURSE_ID").toString());
				courseModel.setCourseName(result.getObject("COURSE_NAME").toString());
				courseInfo.add(courseModel);
			}

			connection.close();
		} catch (NullPointerException e) {
			logger.error("No courses available!" + e.getMessage());
		} catch (SQLException e) {
			logger.error("Error getting courses for TA/Student! "+e.getMessage()+" SQL State:"+e.getSQLState()+" Error code:"+e.getErrorCode());
		}
		return courseInfo;
	}
}