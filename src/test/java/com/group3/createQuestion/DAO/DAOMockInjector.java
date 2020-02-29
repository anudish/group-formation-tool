package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOMockInjector implements IDAOInjector {
    private static DAOMockInjector daoMockInjector;
    IRetrieveQuestionsDAO retrieveQuestionsDAOMock;
	IRemoveQuestionDAO removeQuestionDAOMock;
	
    public static IDAOInjector getInstance() {
        if (null == daoMockInjector) {
            daoMockInjector = new DAOMockInjector();
        }
        return daoMockInjector;
    }
    @Override
    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
        return new RetrieveQuestionTypesDAOMock();
    }

    @Override
    public ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService) {
        return new SaveBasicQuestionInformationDAOMock(iCurrentTimeStampGenerationService);
    }

    @Override
    public IValidationRulesLoaderDAO createValidationRulesLoaderDAO() {
        return new ValidationRulesDAOLoaderMock();
    }
	
	@Override
	public IRetrieveQuestionsDAO createRetrieveQuestionsDAO() {
		if(retrieveQuestionsDAOMock == null) {
        	retrieveQuestionsDAOMock = new RetrieveQuestionsDAOMock();
        }
        return retrieveQuestionsDAOMock;
	}

	@Override
	public IRemoveQuestionDAO createRemoveQuestionDAO() {
		if(removeQuestionDAOMock == null) {
			removeQuestionDAOMock = new RemoveQuestionDAOMock();
		}
		return removeQuestionDAOMock;
	}

}
