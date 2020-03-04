package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOMockInjector implements IDAOInjector {

	public static IDAOInjector idaoInjector;
	public static IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	public static ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO;
	public static IValidationRulesLoaderDAO validationRulesLoaderDAO;
	public static IRetrieveQuestionsDAO retrieveQuestionsDAO;
	public static IRemoveQuestionDAO removeQuestionDAO;

	public static IDAOInjector instance() {
		if (null == idaoInjector) {
			idaoInjector = new DAOMockInjector();
		}
		return idaoInjector;
	}

	@Override
	public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
		if (null == retrieveQuestionTypesDAO) {
			retrieveQuestionTypesDAO = new RetrieveQuestionTypesDAOMock();
		}
		return retrieveQuestionTypesDAO;
	}

	@Override
	public ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService currentTimeStampGenerationService) {
		if (null == saveBasicQuestionInformationDAO) {
			saveBasicQuestionInformationDAO = new SaveBasicQuestionInformationDAOMock(currentTimeStampGenerationService);
		}
		return saveBasicQuestionInformationDAO;
	}

	@Override
	public IValidationRulesLoaderDAO createValidationRulesLoaderDAO() {
		if (null == validationRulesLoaderDAO) {
			validationRulesLoaderDAO = new ValidationRulesDAOLoaderMock();
		}
		return validationRulesLoaderDAO;
	}

	@Override
	public IRetrieveQuestionsDAO createRetrieveQuestionsDAO() {

		if (null == retrieveQuestionsDAO) {
			retrieveQuestionsDAO = new RetrieveQuestionsDAOMock();
		}
		return retrieveQuestionsDAO;
	}

	@Override
	public IRemoveQuestionDAO createRemoveQuestionDAO() {

		if (null == removeQuestionDAO) {
			removeQuestionDAO = new RemoveQuestionDAOMock();
		}
		return removeQuestionDAO;
	}
}