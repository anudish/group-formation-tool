package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.QuestionTypes;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;

import java.util.ArrayList;

public class ObtainAllQuestionTypesService implements IObtainAllQuestionTypesService {

	private IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO;
	private ArrayList<QuestionTypes> questionTypes;

	public ObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO) {

		this.iRetrieveQuestionTypesDAO = iRetrieveQuestionTypesDAO;
	}

	@Override
	public ArrayList<QuestionTypes> getAllQuestionTypes() {

		questionTypes = this.iRetrieveQuestionTypesDAO.getQuestionTypes();
		return questionTypes;
	}
}