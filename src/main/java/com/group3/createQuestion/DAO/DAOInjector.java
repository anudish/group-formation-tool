package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.DAOInjector;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOInjector implements IDAOInjector {

	static IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	static ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO;
	static IValidationRulesLoaderDAO validationRulesLoaderDAO;
	static IRetrieveQuestionsDAO retrieveQuestionsDAO;
	static IRemoveQuestionDAO removeQuestionDAO;	
	
	private static IDAOInjector idaoInjector;
	
    public static IDAOInjector getInstance(){
        if (null == idaoInjector){
            idaoInjector = new DAOInjector();
        }
        return idaoInjector;
    }
    @Override
    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
    	if(retrieveQuestionTypesDAO == null) {
    		retrieveQuestionTypesDAO = new RetrieveQuestionTypesDAO();
    	}
    	return retrieveQuestionTypesDAO;
    }

    @Override
    public ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService) {
    	if(saveBasicQuestionInformationDAO == null) {
    		saveBasicQuestionInformationDAO = new SaveBasicQuestionInformationDAO(iCurrentTimeStampGenerationService);
    	}
    	return saveBasicQuestionInformationDAO;
    }

    @Override
    public IValidationRulesLoaderDAO createValidationRulesLoaderDAO() {
    	if(validationRulesLoaderDAO == null) {
    		validationRulesLoaderDAO = new ValidationRulesLoaderDAO();
    	}
    	return validationRulesLoaderDAO;
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
