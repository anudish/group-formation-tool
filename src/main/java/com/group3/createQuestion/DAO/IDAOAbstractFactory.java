package com.group3.createQuestion.DAO;

import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public interface IDAOAbstractFactory {
    IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO();
    ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService);
    IValidationRulesLoaderDAO createValidationRulesLoaderDAO();
	IRetrieveQuestionsDAO createRetrieveQuestionsDAO();
	IRemoveQuestionDAO createRemoveQuestionDAO();
	ISaveMCQAnswerstoDataBaseDAO createSaveMCQAnswertoDataBaseDAO();
}
