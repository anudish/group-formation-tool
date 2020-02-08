package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.Student;
import com.group3.DAO.CourseDAO;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class InsertTestDataIntoDB {

	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	CourseModel courseModel;
	ArrayList<CourseModel> courseInfo;
	
	public void InstructorDAOTest_insertEnrollment(String instId, String courseId) throws Exception {

		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "insert into COURSES values ('"+courseId+"','TEST')";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test Course ID Inserted!");
        
		sql = "insert into ALLOCATE_INSTRUCTOR values ('"+instId+"','"+courseId+"')";
        statement = conn.prepareStatement(sql);		
        result = statement.executeUpdate();
        System.out.println("Test Course ID Inserted!");
        conn.close();
		
	}
	
	public void TADAOTest_insertEnrollment(Student student, String courseId) throws Exception {

		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "insert into COURSES values ('"+courseId+"','TEST');";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test Course ID Inserted!");
        
		sql = "insert into student_enrollments values ('"+student.getBannerId()+"','"+student.getEmail()+"','"+courseId+"')";
        statement = conn.prepareStatement(sql);		
        result = statement.executeUpdate();
        System.out.println("Test Course ID Inserted!");
        conn.close();
	}
	
	public void StudentDAOTest_insertStudent(Student student) throws Exception{
		
		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "insert into USER_DATABASE values ('"+student.getLastName()+"','"+student.getFirstName()+"','Student','"+student.getEmail()+"');";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test User Inserted!");
		conn.close();
	}
	
	public void StudentDAOTest_updateTA(Student student) throws Exception{
		
		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "update USER_DATABASE set ROLE = 'TA' where MAIL_ID = '"+student.getEmail()+"';";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test User Inserted!");
		conn.close();
	}
	
}
