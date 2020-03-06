package com.group3.CreateQuestion.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.group3.BusinessModels.Instructor;

import com.group3.CreateQuestion.DAO.IDAOAbstractFactory;
import com.group3.CreateQuestion.DAO.IRetrieveQuestionsDAO;

public class ObtainQuestionsService implements IObtainQuestionsService {
	IRetrieveQuestionsDAO retrieveQuestionsDAO;
	IDAOAbstractFactory daoInjector;

	private static Logger logger = LogManager.getLogger(ObtainQuestionsService.class);

	public ObtainQuestionsService(IRetrieveQuestionsDAO retrieveQuestionsDAO) {

		this.retrieveQuestionsDAO = retrieveQuestionsDAO;
		logger.info("ObtainQuestions constructor called!");
	}

	@Override
	public List<List<String>> obtainInstructorQuestions(Instructor instructor, String order) {

		List<List<String>> questionList = new ArrayList<List<String>>();
		logger.info("Starting the process of retrieving instructor questions!");
		try {
		questionList = retrieveQuestionsDAO.getQuestionsByInstructorID(instructor.getEmail(), order);
		logger.info("Retrieved instructor questions!");
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		} catch (IndexOutOfBoundsException ind) {
			logger.error(ind.getMessage());
		}
		return questionList;
	}

}