package com.group3.CreateQuestion.Services;

import com.group3.CreateQuestion.BusinessModels.QuestionTypes;
import com.group3.CreateQuestion.DAO.IRetrieveQuestionTypesDAO;

import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class ObtainAllQuestionTypesService implements IObtainAllQuestionTypesService {
	public static Logger logger = LogManager.getLogger(ObtainAllQuestionTypesService.class);
	private IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	private ArrayList<QuestionTypes> questionTypes;

	public ObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO) {

		this.retrieveQuestionTypesDAO = retrieveQuestionTypesDAO;
	}

	@Override
	public ArrayList<QuestionTypes> getAllQuestionTypes() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
		questionTypes = this.retrieveQuestionTypesDAO.getQuestionTypes();
		} catch (IndexOutOfBoundsException e) {
			logger.error(e.getMessage());
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		}
		return questionTypes;
	}
}