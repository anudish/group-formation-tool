package com.group3.Course.DAO;

import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.Student;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class RemoveTestDataFromDB {

	Connection connection;
	String sql;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	Course courseModel;
	ArrayList<Course> courseInfo;
	int result;

	public void CourseEnrollmentsDAOTest_removeEnrollment(Student student, String courseId) throws Exception {

		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from student_enrollments where MAIL_ID ='" + student.getEmail() + "' and COURSE_ID = '" + courseId
				+ "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();

		sql = "delete from USER_DATABASE where MAIL_ID ='" + student.getEmail() + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();

		sql = "delete from AUTHENTICATION_DATABASE where MAIL_ID ='" + student.getEmail() + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();
		connection.close();
	}

	public void InstructorDAOTest_removeEnrollment(String instId, String courseId) throws Exception {

		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from COURSES where COURSE_ID ='" + courseId + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();

		sql = "delete from ALLOCATE_INSTRUCTOR where MAIL_ID ='" + instId + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();
		connection.close();
	}

	public void TADAOTest_removeEnrollment(Student student, String courseId) throws Exception {

		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from COURSES where COURSE_ID ='" + courseId + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();

		sql = "delete from student_enrollments where COURSE_ID ='" + courseId + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();
		connection.close();
	}

	public void StudentDAOTest_removeStudent(Student student) throws Exception {

		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from USER_DATABASE where MAIL_ID ='" + student.getEmail() + "'";
		statement = connection.prepareStatement(sql);
		result = statement.executeUpdate();
		connection.close();

	}

}