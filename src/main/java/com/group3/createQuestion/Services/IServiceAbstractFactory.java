package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;

public interface IServiceAbstractFactory {
    public IObtainAllQuestionTypesService createObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO);
}
