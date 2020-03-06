package com.group3.CreateQuestion.DAO;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.CreateQuestion.Services.ICurrentTimeStampGenerationService;

import java.sql.*;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SaveBasicQuestionInformationDAO implements ISaveBasicQuestionInformationDAO {
	private String query, feedbackMessage;
	private Connection connection;
	private PreparedStatement statement;
	private Timestamp currentTimestamp;
	private ICurrentTimeStampGenerationService currentTimeStampGenerationService;
	private static Logger logger = LogManager.getLogger(SaveBasicQuestionInformationDAO.class);

	public SaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService currentTimeStampGenerationService) {

		this.currentTimeStampGenerationService = currentTimeStampGenerationService;
		feedbackMessage = new String();
	}

	@Override
	public String saveDetailsAndReturnId(String title, String text, String type) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	
		ResultSet resultSet;
		query = "INSERT INTO QUESTIONS(TITLE,TEXT,TYPE,TIMESTAMP) VALUES(?,?,?,?)";
		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
		Authentication authentication;
		String email;

		try {
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, title);
			statement.setString(2, text);
			statement.setString(3, type);
			this.currentTimestamp = this.currentTimeStampGenerationService.returnCurrentTimeStamp();
			statement.setTimestamp(4, this.currentTimestamp);
			statement.execute();

			resultSet = statement.getGeneratedKeys();
			resultSet.next();

			if (resultSet != null) {
				feedbackMessage = String.valueOf(resultSet.getInt(1));
				logger.info("returned value database : " + feedbackMessage);
			}
			
		} catch (SQLException e) {
			logger.error("error connecting with server !" + e.getMessage());
		}
		
		query = "INSERT INTO INSTRUCTOR_QUESTION_MAPPING VALUES(?,?)";
		
		try {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			email = authentication.getName();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, email);
			statement.setString(2, feedbackMessage);
			statement.execute();

		}catch(SQLException e){
			logger.error("error connecting with server !" + e.getMessage());
		}
		return feedbackMessage;
	}
}
