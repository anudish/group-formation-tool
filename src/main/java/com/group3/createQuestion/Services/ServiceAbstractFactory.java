package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;

public class ServiceAbstractFactory implements IServiceAbstractFactory {
    @Override
    public IObtainAllQuestionTypesService createObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO) {
        return new ObtainAllQuestionTypesService(iRetrieveQuestionTypesDAO);
    }
}
