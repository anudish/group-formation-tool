package com.group3.CreateQuestion.Services;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.group3.CreateQuestion.DAO.IRemoveQuestionDAO;

public class DeleteQuestionService implements IDeleteQuestionService {

	private static IRemoveQuestionDAO removeQuestionDAO;
	public static Logger logger = LogManager.getLogger(DeleteQuestionService.class);

	public DeleteQuestionService(IRemoveQuestionDAO removeQuestionDAO) {

		this.removeQuestionDAO = removeQuestionDAO;
		logger.info("DeleteQuestionService constructor called!");
	}

	@Override
	public boolean deleteQuestionByQuestionId(String questionId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		
		logger.info("Starting the process of deleting question: " + questionId + "!");
		try {
			boolean result = removeQuestionDAO.removeQuestionFromDatabase(questionId);
			logger.info("QuestionId : " + questionId + " deleted!");
			return result;
			
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return false;
		}
	}

}
