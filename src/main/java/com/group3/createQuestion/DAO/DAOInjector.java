package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.DAOInjector;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOInjector implements IDAOInjector {

	IRetrieveQuestionsDAO retrieveQuestionsDAO;
	IRemoveQuestionDAO removeQuestionDAO;	
	
	private static IDAOInjector idaoInjector;
    public static IDAOInjector getInstance(){
        if (null == idaoInjector){
            idaoInjector = new DAOInjector();
        }
        return idaoInjector;
    }
    @Override
    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
        return new RetrieveQuestionTypesDAO();
    }

    @Override
    public ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService) {
        return new SaveBasicQuestionInformationDAO(iCurrentTimeStampGenerationService);
    }

    @Override
    public IValidationRulesLoaderDAO createValidationRulesLoaderDAO() {
        return new ValidationRulesLoaderDAO();
    }
    

	@Override
	public IRetrieveQuestionsDAO createRetrieveQuestionsDAO() {
		
		if(retrieveQuestionsDAO == null) {
			retrieveQuestionsDAO = new RetrieveQuestionsDAO();
		}
		return retrieveQuestionsDAO;
	}

	@Override
	public IRemoveQuestionDAO createRemoveQuestionDAO() {
		
		if(removeQuestionDAO == null) {
			removeQuestionDAO = new RemoveQuestionDAO();
		}
		return removeQuestionDAO;
	}
}
