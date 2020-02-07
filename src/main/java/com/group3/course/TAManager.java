package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.Student;
import com.group3.DAO.DAOInjector;
import com.group3.DAO.ICourseDAO;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IStudentDAO;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class TAManager implements ITAManager {
	
	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(TAManager.class);
	PreparedStatement statement;
	
	IStudentDAO studentDAO;
	IDAOInjector daoInjector;
	
	public TAManager(IDAOInjector daoInjector) {
		studentDAO = daoInjector.createStudentDAO();
	}
	
	public ArrayList<Student> getAllStudents() {
		
		ArrayList<Student> rows = studentDAO.getAllStudents();
		return rows;
	}
	
	public ArrayList<Student> getStudentByMailId(String studentMailId) {
		
		ArrayList<Student> rows = studentDAO.getStudentByMailId(studentMailId);
		return rows;
	}
	
	public void addTA(String studentMailId) {
		studentDAO.assignTA(studentMailId);
	}
}
