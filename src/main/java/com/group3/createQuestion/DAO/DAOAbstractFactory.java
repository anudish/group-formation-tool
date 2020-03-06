package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.DAOAbstractFactory;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory daoInjector;
	public static IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	public static ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO;
	public static IValidationRulesLoaderDAO validationRulesLoaderDAO;
	public static IRetrieveQuestionsDAO retrieveQuestionsDAO;
	public static IRemoveQuestionDAO removeQuestionDAO;

	public static IDAOAbstractFactory instance() {
		if (null == daoInjector) {
			daoInjector = new DAOAbstractFactory();
		}
		return daoInjector;
	}

	@Override
	public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
		if (null == retrieveQuestionTypesDAO) {
			retrieveQuestionTypesDAO = new RetrieveQuestionTypesDAO();
		}
		return retrieveQuestionTypesDAO;
	}

	@Override
	public ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(
			ICurrentTimeStampGenerationService currentTimeStampGenerationService) {
		if (null == saveBasicQuestionInformationDAO) {
			saveBasicQuestionInformationDAO = new SaveBasicQuestionInformationDAO(currentTimeStampGenerationService);
		}
		return saveBasicQuestionInformationDAO;
	}

	@Override
	public IValidationRulesLoaderDAO createValidationRulesLoaderDAO() {
		if (null == validationRulesLoaderDAO) {
			validationRulesLoaderDAO = new ValidationRulesLoaderDAO();
		}
		return validationRulesLoaderDAO;
	}

	@Override
	public IRetrieveQuestionsDAO createRetrieveQuestionsDAO() {

		if (null == retrieveQuestionsDAO) {
			retrieveQuestionsDAO = new RetrieveQuestionsDAO();
		}
		return retrieveQuestionsDAO;
	}

	@Override
	public IRemoveQuestionDAO createRemoveQuestionDAO() {

		if (null == removeQuestionDAO) {
			removeQuestionDAO = new RemoveQuestionDAO();
		}
		return removeQuestionDAO;
	}

	@Override
	public ISaveMCQAnswerstoDataBaseDAO createSaveMCQAnswertoDataBaseDAO() {
		return new SaveMCQAnswerstoDataBaseDAO();
	}
}
