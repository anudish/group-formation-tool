package com.group3.createQuestion.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.DAO.CourseDAO;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.BusinessModels.Question;

//Krutarth

public class RetrieveQuestionsDAO implements IRetrieveQuestionsDAO{

	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(RetrieveQuestionsDAO.class);
	PreparedStatement statement;
	
	@Override
	public List<List<String>> getQuestionsByInstructorID(String instructorId) {
		
		List<List<String>> instructorQuestions = new ArrayList<List<String>>();
		List<String> questionInfo;
		
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			
			logger.info("Fetching questions for instructor: "+instructorId);
			
			sql = "select * from QUESTIONS Q "
					+ "JOIN INSTRUCTOR_QUESTION_MAPPING I "
					+ "WHERE I.INSTRUCTOR_ID = '"+instructorId+"' AND I.QUESTION_ID = Q.QUESTION_ID;";
	        statement = conn.prepareStatement(sql);
	
	        ResultSet result = statement.executeQuery();
	        while (result.next()) {
	        	String id = String.valueOf(result.getObject("QUESTION_ID"));
	        	String title = String.valueOf(result.getObject("TITLE"));
	            String text = String.valueOf(result.getObject("TEXT"));
	            String type = String.valueOf(result.getObject("TYPE"));
	            String timestamp = String.valueOf(result.getObject("TIMESTAMP"));
	            
	        	logger.info("Question fetched: "+id);
	    
	        	questionInfo = new ArrayList<String>();
	        	questionInfo.add(id);
	        	questionInfo.add(title);
	        	questionInfo.add(text);
	        	questionInfo.add(type);
	        	questionInfo.add(timestamp);
	        	
	        	instructorQuestions.add(questionInfo);
	        }
	        
 			conn.close();

	        logger.info("Questions fetched for the instructor with ID: "+instructorId);
		}
		catch(Exception e) {
			logger.info("Exception at RetrieveQuestionsDAO while fetching instructor questions! "+e);	
		}
		return instructorQuestions;
		
	}

}
