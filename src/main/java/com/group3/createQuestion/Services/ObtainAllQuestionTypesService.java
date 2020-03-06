package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.QuestionTypes;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;

import java.util.ArrayList;

public class ObtainAllQuestionTypesService implements IObtainAllQuestionTypesService {
	private IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	private ArrayList<QuestionTypes> questionTypes;

	public ObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO) {

		this.retrieveQuestionTypesDAO = retrieveQuestionTypesDAO;
	}

	@Override
	public ArrayList<QuestionTypes> getAllQuestionTypes() {

		questionTypes = this.retrieveQuestionTypesDAO.getQuestionTypes();
		return questionTypes;
	}
}