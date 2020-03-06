package com.group3.AdminAndAuthorization.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class ViewCoursesDAO implements IViewCoursesDAO {
	ArrayList<Course> allCourses;
	Course course;
	Connection connection;
	String query;
	String courseId;
	String courseName;

	private static Logger logger = LogManager.getLogger(ViewCoursesDAO.class);

	public ViewCoursesDAO() {
		allCourses = new ArrayList<>();
	}

	@Override
	public ArrayList<Course> getAllCourses() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		ResultSet result;
		query = "Select *from COURSES";
		connection = ObtainDataBaseConnection.obtainDatabaseConnection();

		try {
			result = connection.createStatement().executeQuery(query);

			if (result.next() == false) {
				return allCourses;
			} else {
				result.previous();

				while (result.next()) {
					courseId = result.getString("COURSE_ID");
					courseName = result.getString("COURSE_NAME");

					course = new Course();
					course.setCourseId(courseId);
					course.setCourseName(courseName);

					allCourses.add(course);
				}
			}
		}

		catch (SQLException e) {
			logger.error(e.getMessage() + " The SQL State is :" + e.getSQLState() + ". Error Code : " + e.getErrorCode());
		} finally {
			ObtainDataBaseConnection.terminateConnection();
		}

		return allCourses;
	}
}