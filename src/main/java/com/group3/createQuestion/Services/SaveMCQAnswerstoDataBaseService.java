package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.MCQAnswers;
import com.group3.createQuestion.DAO.ISaveMCQAnswerstoDataBaseDAO;

import java.util.ArrayList;

public class SaveMCQAnswerstoDataBaseService extends QuestionService {
	public SaveMCQAnswerstoDataBaseService() {
		super(QuestionGenerationServicesEnum.MCQS_ONE);
	}

	public int saveMCQAnswertoDataBase(ISaveMCQAnswerstoDataBaseDAO saveMCQAnswerstoDataBaseDAO, int questionId,
			ArrayList<MCQAnswers> mcqAnswers) {

		int success = saveMCQAnswerstoDataBaseDAO.saveOptionsToDataBase(questionId, mcqAnswers);
		return success;
	}
}
