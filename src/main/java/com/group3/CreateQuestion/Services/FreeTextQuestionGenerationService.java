package com.group3.CreateQuestion.Services;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.CreateQuestion.DAO.ISaveBasicQuestionInformationDAO;

public class FreeTextQuestionGenerationService extends QuestionService {

	private String title, question;
    public static Logger logger = LogManager.getLogger(FreeTextQuestionGenerationService.class);

	public FreeTextQuestionGenerationService() {
		super(QuestionGenerationServicesEnum.FREE_TEXT);
	}

	public String saveFreeTextQuestionGenerationServiceInfo(String title, String question, String type,
			ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO) {
    	PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
		String feedbackMessage = super.saveBasicQuestionInformation(title, question, type,
				saveBasicQuestionInformationDAO);
		return feedbackMessage;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return null;
		} catch(StringIndexOutOfBoundsException str) {
			logger.error(str.getMessage());
			return null;
	}
    }
}
