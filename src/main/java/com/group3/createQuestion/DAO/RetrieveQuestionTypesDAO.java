package com.group3.createQuestion.DAO;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.BusinessModels.QuestionTypes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetrieveQuestionTypesDAO implements IRetrieveQuestionTypesDAO {

	private ArrayList<QuestionTypes> questionType;
	private String queryString, questionTypeText;
	private Connection databaseConnection;
	private PreparedStatement statement;
	private static Logger logger = LogManager.getLogger(RetrieveQuestionTypesDAO.class);

	@Override
	public ArrayList<QuestionTypes> getQuestionTypes() {

		ResultSet resultSet;
		questionType = new ArrayList<>();
		queryString = "select TYPES from QUESTION_TYPE";
		
		try {
			databaseConnection = ObtainDataBaseConnection.obtainDatabaseConnection();
			statement = databaseConnection.prepareStatement(queryString);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				logger.info(resultSet.getObject("TYPES"));
				questionTypeText = resultSet.getObject("TYPES").toString();
				QuestionTypes questTypeInstance = new QuestionTypes();
				questTypeInstance.setQuestionType(questionTypeText);
				questionType.add(questTypeInstance);
			}
		} catch (SQLException e) {
			logger.error("facing database server connectivity error");
		}
		return questionType;
	}
}