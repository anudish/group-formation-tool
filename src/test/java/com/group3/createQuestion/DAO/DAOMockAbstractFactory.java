package com.group3.createQuestion.DAO;

import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOMockAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory idaoInjector;
	public static IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	public static ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO;
	public static IValidationRulesLoaderDAO validationRulesLoaderDAO;
	public static IRetrieveQuestionsDAO retrieveQuestionsDAO;
	public static IRemoveQuestionDAO removeQuestionDAO;

	public static IDAOAbstractFactory instance() {
		if (null == idaoInjector) {
			idaoInjector = new DAOMockAbstractFactory();
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

	@Override
	public ISaveMCQAnswerstoDataBaseDAO createSaveMCQAnswertoDataBaseDAO() {
		return null;
	}
}