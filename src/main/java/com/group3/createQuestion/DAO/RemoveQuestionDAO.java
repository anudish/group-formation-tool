package com.group3.createQuestion.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

//Krutarth

public class RemoveQuestionDAO implements IRemoveQuestionDAO {
	
	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(RetrieveQuestionsDAO.class);
	PreparedStatement statement;
	
	public boolean removeQuestionFromDatabase(String questionId) {
		boolean result = true;
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			
			logger.info("Deleting questionId: "+questionId);
			
			sql = "delete Q, MCQ, SQ, IQM, R "
					+ "from QUESTIONS Q "
					+ "LEFT JOIN MULTIPLE_CHOICE_QUESTIONS MCQ on MCQ.QUESTION_ID=Q.QUESTION_ID "
					+ "LEFT JOIN SURVEY_QUESTIONS SQ on SQ.QUESTION_ID=Q.QUESTION_ID "
					+ "LEFT JOIN INSTRUCTOR_QUESTION_MAPPING IQM on IQM.QUESTION_ID=Q.QUESTION_ID "
					+ "LEFT JOIN RESPONSE R on R.QUESTION_ID=Q.QUESTION_ID "
					+ "WHERE Q.QUESTION_ID = "+questionId+";";

	        statement = conn.prepareStatement(sql);
	        int res = statement.executeUpdate();
        	logger.info("Question Id: "+questionId+" along with all its mappings in QUESTIONS, MULTIPLE_CHOICE_QUESTIONS, INSTRUCTOR_QUESTION_MAPPING, SURVEY_QUESTIONS, AND RESPONSE deleted!"); 
 			conn.close();

		}
		catch(Exception e) {
			logger.info("Exception at RemoveQuestionDAO while deleting everything related to questionID"+questionId+"! "+e);
			result=false;
		}
		return result;
	}
}
