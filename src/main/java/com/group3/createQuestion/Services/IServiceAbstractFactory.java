package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IRemoveQuestionDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;

public interface IServiceAbstractFactory {
     IObtainAllQuestionTypesService createObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO);
     ICurrentTimeStampGenerationService createCurrentTimeStampGenerationService();
     IStringValidatorService createStringValidatorService(IValidationRulesLoaderDAO iValidationRulesLoaderDAO);
     IMakeQuestionGenerationAbstractFactory createMakeQuestionGenerationAbstractFactory();
     IReturnControllerPathService createReturnControllerPathService();
     IQuestionService createfreeTextQuestionGenerationService();
     IQuestionService createNumericQuestionGenerationService();
     IObtainQuestionsService createObtainQuestionsService(IRetrieveQuestionsDAO retrieveQuestionDAO);
     IDeleteQuestionService createDeleteQuestionService(IRemoveQuestionDAO removeQuestionDAO);
     ISplitMCQSAnswerService createSplitMCQSAnswerService();
     IQuestionService createSaveMCQAnswerstoDataBaseService();
}
