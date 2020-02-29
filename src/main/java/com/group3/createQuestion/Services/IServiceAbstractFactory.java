package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;

public interface IServiceAbstractFactory {
     IObtainAllQuestionTypesService createObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO);
     ICurrentTimeStampGenerationService createCurrentTimeStampGenerationService();
     IStringValidatorService createStringValidatorService(IValidationRulesLoaderDAO iValidationRulesLoaderDAO);
     IMakeQuestionGenerationAbstractFactory createMakeQuestionGenerationAbstractFactory();
     IReturnControllerPathService createReturnControllerPathService();
     IQuestionService createfreeTextQuestionGenerationService();
}
