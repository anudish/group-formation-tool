package com.group3.AdminAndAuthorization.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.group3.BusinessModels.Course;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class DeleteCourseDAO implements IDeleteCourseDAO {
	Connection connection;
	String query;
	PreparedStatement statement;

	private static Logger logger = LogManager.getLogger(DeleteCourseDAO.class);

	@Override
	public String deleteCourse(Course course) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		query = "delete from COURSES WHERE COURSE_ID = ? ";
		String feedBackMessage = new String();
		int rowsEffected;

		try {
			logger.info("The Course ID is : " + course.getCourseId());
			connection = ObtainDataBaseConnection.obtainDatabaseConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, course.getCourseId());
			rowsEffected = statement.executeUpdate();

			if (rowsEffected == 1) {
				feedBackMessage = course.getCourseName() + " (" + course.getCourseId() + ") "
						+ " is deleted sucessfully ";
			} else {
				feedBackMessage = "Error occured while deleting the course";
			}
		} catch (SQLException e) {
			feedBackMessage = "Server not responding";
			logger.log(Level.ERROR,
			e.getMessage() + " The SQL State is :" + e.getSQLState() + ". Error Code : " + e.getErrorCode());
		} finally {
			ObtainDataBaseConnection.terminateConnection();
		}

		return feedBackMessage;
	}
}