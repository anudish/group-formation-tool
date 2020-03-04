package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

public class NumericQuestionGenerationService extends QuestionService {

	public NumericQuestionGenerationService() {

		super(QuestionGenerationServicesEnum.NUMERIC);
	}

	public String saveNumericQuestion(String title, String question, String type, ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO) {

		String feedbackMessage = super.saveBasicQuestionInformation(title, question, type, iSaveBasicQuestionInformationDAO);
		return feedbackMessage;
	}
}