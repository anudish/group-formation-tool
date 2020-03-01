package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IRemoveQuestionDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;

public class ServiceAbstractFactory implements IServiceAbstractFactory {
    
	IObtainQuestionsService obtainQuestionsService;
	IDeleteQuestionService deleteQuestionService;
	
	@Override
    public IObtainAllQuestionTypesService createObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO) {
        return new ObtainAllQuestionTypesService(iRetrieveQuestionTypesDAO);
    }

    @Override
    public ICurrentTimeStampGenerationService createCurrentTimeStampGenerationService() {
        return new CurrentTimeStampGenerationService();
    }

    @Override
    public IStringValidatorService createStringValidatorService(IValidationRulesLoaderDAO iValidationRulesLoaderDAO) {
        return new StringValidatorService(iValidationRulesLoaderDAO);
    }

    @Override
    public IMakeQuestionGenerationAbstractFactory createMakeQuestionGenerationAbstractFactory() {
        return new MakeQuestionGenerationAbstractFactory();
    }

    @Override
    public IReturnControllerPathService createReturnControllerPathService() {
        return new ReturnControllerPathService();
    }

    @Override
    public IQuestionService createfreeTextQuestionGenerationService() {
        return new freeTextQuestionGenerationService();
    }
    
    @Override
    public IQuestionService createNumericQuestionGenerationService() {
        return new NumericQuestionGenerationService();
    }

    @Override
    public IObtainQuestionsService createObtainQuestionsService(IRetrieveQuestionsDAO retrieveQuestionDAO) {
		if(obtainQuestionsService == null) {
			obtainQuestionsService = new ObtainQuestionsService(retrieveQuestionDAO); 
		}
		return obtainQuestionsService;
    }

	@Override
	public IDeleteQuestionService createDeleteQuestionService(IRemoveQuestionDAO removeQuestionDAO) {
		if(deleteQuestionService == null) {
			deleteQuestionService = new DeleteQuestionService(removeQuestionDAO); 
		}
		return deleteQuestionService;
	}

}
