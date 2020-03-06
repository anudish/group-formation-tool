package com.group3.Course.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.BusinessModels.Student;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.Course.CourseController;

public class StudentDAO implements IStudentDAO {
    private static Logger logger = LogManager.getLogger(StudentDAO.class);
    Connection connection;
    String query;
    PreparedStatement statement;
    Student studentDetails;

    @Override
    public ArrayList<Student> getAllStudents() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        ArrayList<Student> rows = new ArrayList<Student>();
        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();
            query = "SELECT * FROM USER_DATABASE where ROLE = 'Student'";
            statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            logger.info("QUERY EXECUTED");
            while (result.next()) {
                logger.info(result.getObject("LAST_NAME"));
                studentDetails = new Student();
                studentDetails.setLastName(result.getObject("LAST_NAME").toString());
                studentDetails.setFirstName(result.getObject("FIRST_NAME").toString());
                studentDetails.setEmail(result.getObject("MAIL_ID").toString());
                rows.add(studentDetails);
            }

            connection.close();
            logger.info("GET ENROLLED STUDENTS QUERY EXECUTED");
        } catch (NullPointerException e) {
            logger.error("No user enrolled as student in database" + e.getMessage());
        } catch (SQLException e) {
            logger.error("Error getting students! " + e.getMessage() + " SQL State:" + e.getSQLState() + " Error code:" + e.getErrorCode());
        }
        return rows;
    }

    @Override
    public ArrayList<Student> getStudentByMailId(String studentMailId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
        ArrayList<Student> rows = new ArrayList<Student>();
        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();
            query = "SELECT * FROM USER_DATABASE where (ROLE = 'Student' OR ROLE = 'TA') and MAIL_ID LIKE '%"
                    + studentMailId + "%'";
            statement = connection.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            logger.info("SEARCH STUDENT QUERY EXECUTED");
            while (result.next()) {
                logger.info(result.getObject("LAST_NAME"));
                studentDetails = new Student();
                studentDetails.setLastName(result.getObject("LAST_NAME").toString());
                studentDetails.setFirstName(result.getObject("FIRST_NAME").toString());
                studentDetails.setEmail(result.getObject("MAIL_ID").toString());
                studentDetails.setUserRole(result.getObject("ROLE").toString());
                rows.add(studentDetails);
            }

            connection.close();
        } catch (NullPointerException e) {
			logger.error("No student enrolled with "+studentMailId+" "+e.getMessage());
		} catch (SQLException e) {
			logger.error("Error getting student! "+studentMailId+" "+e.getMessage()+" SQL State:"+e.getSQLState()+" Error code:"+e.getErrorCode());
		}
        return rows;
    }

    public void assignTA(String studentMailId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
        int queryResult;
        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();
            query = "insert into COURSE_TA (MAIL_ID,COURSE_ID) values ('" + studentMailId + "','"
                    + CourseController.courseId + "')";
            statement = connection.prepareStatement(query);

            queryResult = statement.executeUpdate();

            query = "update USER_DATABASE SET ROLE = 'TA' where MAIL_ID='" + studentMailId + "'";
            statement = connection.prepareStatement(query);
            queryResult = statement.executeUpdate();

            connection.close();
            logger.info("WRITE TO DATABASE SUCCESSFUL!");
        } catch (SQLException e) {
			logger.error("Error assigning student as TA! "+studentMailId+" "+e.getMessage()+" SQL State:"+e.getSQLState()+" Error code:"+e.getErrorCode());
        }
    }
}