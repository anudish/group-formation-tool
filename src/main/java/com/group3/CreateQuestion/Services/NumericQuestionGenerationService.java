package com.group3.CreateQuestion.Services;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.CreateQuestion.DAO.ISaveBasicQuestionInformationDAO;

public class NumericQuestionGenerationService extends QuestionService {
	public static Logger logger = LogManager.getLogger(NumericQuestionGenerationService.class);

	public NumericQuestionGenerationService() {

		super(QuestionGenerationServicesEnum.NUMERIC);
	}

	public String saveNumericQuestion(String title, String question, String type,
			ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
		String feedbackMessage = super.saveBasicQuestionInformation(title, question, type,
				saveBasicQuestionInformationDAO);
		return feedbackMessage;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}