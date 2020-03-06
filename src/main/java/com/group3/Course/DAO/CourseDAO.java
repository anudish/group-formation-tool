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
import com.group3.BusinessModels.Student;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class CourseDAO implements ICourseDAO {
	Connection connection;
	String query;
	PreparedStatement statement;
	Course courseModel;

	private static Logger logger = LogManager.getLogger(CourseDAO.class);

	public ArrayList<String> getEnrolledStudentsByCourseId(String courseId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		ResultSet result;
		ArrayList<String> current_students = new ArrayList<String>();
		try {
			connection = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "SELECT *FROM student_enrollments where COURSE_ID='" + courseId + "'";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();

			while (result.next()) {
				logger.info(result.getObject("COURSE_ID"));
				current_students.add(result.getObject("MAIL_ID").toString());
			}
			connection.close();
			logger.info("GET ENROLLED STUDENTS QUERY EXECUTED");
		}catch (NullPointerException e) {
			logger.error("No students enrolled to " + courseId + " " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Error getting courses for Guest! " + e.getMessage() + " SQL State:" + e.getSQLState() + " Error code:" + e.getErrorCode());
		}
		return current_students;
	}

	public void enrollStudentToCourse(Student studentDetails, String courseId) {
		int queryResult;
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
			connection = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "insert into student_enrollments (BANNER_ID,MAIL_ID,COURSE_ID) values ('"
					+ studentDetails.getBannerId() + "','" + studentDetails.getEmail() + "','" + courseId + "')";
			statement = connection.prepareStatement(query);
			queryResult = statement.executeUpdate();
			logger.debug("Added into student_enrollment table: " + queryResult);

			query = "insert into USER_DATABASE (MAIL_ID,FIRST_NAME,LAST_NAME,ROLE) values ('"
					+ studentDetails.getEmail() + "','" + studentDetails.getFirstName() + "','"
					+ studentDetails.getLastName() + "','Student')";
			statement = connection.prepareStatement(query);
			queryResult = statement.executeUpdate();
			logger.debug("Added into USER_DATABASE table: " + queryResult);

			query = "insert into AUTHENTICATION_DATABASE (MAIL_ID,PASSWORD) values ('" + studentDetails.getEmail()
					+ "','" + studentDetails.getEncryptedPassword() + "')";
			statement = connection.prepareStatement(query);
			queryResult = statement.executeUpdate();
			logger.debug("Added into AUTHENTICATION table: " + queryResult);

			connection.close();
			logger.info("ENROLL STUDENTS QUERY EXECUTED");
		}catch (SQLException e) {
			logger.error("Error adding students to database! " + e.getMessage() + " SQL State:" + e.getSQLState() + " Error code:" + e.getErrorCode());
		}
	}

	@Override
	public ArrayList<Course> getCoursesForGuest() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		ResultSet result;
		ArrayList<Course> courseInfo = new ArrayList<Course>();
		try {
			connection = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "SELECT C.COURSE_ID, C.COURSE_NAME FROM COURSES C";
			statement = connection.prepareStatement(query);

			result = statement.executeQuery();
			courseInfo = new ArrayList<Course>();
			while (result.next()) {
				logger.info(result.getObject("COURSE_ID") + ": " + result.getObject("COURSE_NAME"));
				courseModel = new Course();
				courseModel.setCourseId(result.getObject("COURSE_ID").toString());
				courseModel.setCourseName(result.getObject("COURSE_NAME").toString());
				courseInfo.add(courseModel);
			}
			connection.close();
			logger.info("GETTING COURSES FOR GUEST QUERY EXECUTED");
		} catch (NullPointerException e) {
			logger.error("No courses available!" + e.getMessage());
		} catch (SQLException e) {
			logger.error("Error getting courses for Guest! "+e.getMessage()+" SQL State:"+e.getSQLState()+" Error code:"+e.getErrorCode());
		}

		return courseInfo;
	}
}