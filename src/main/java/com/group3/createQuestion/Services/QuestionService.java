package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.Question;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

public abstract class QuestionService implements IQuestionService {

	private QuestionGenerationServicesEnum questionGenerationServicesEnum;

	public QuestionService(QuestionGenerationServicesEnum questionGenerationServicesEnum) {

		this.questionGenerationServicesEnum = questionGenerationServicesEnum;
	}

	@Override
	public String saveBasicQuestionInformation(String questionTitle, String questionText, String questionType, ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO) {

		String feedbackMessage = Question.saveBasicInformationIntoDatabase(iSaveBasicQuestionInformationDAO, questionTitle, questionText, questionType);
		return feedbackMessage;
	}

	@Override
	public QuestionGenerationServicesEnum getQuestionType() {

		return questionGenerationServicesEnum;
	}
}