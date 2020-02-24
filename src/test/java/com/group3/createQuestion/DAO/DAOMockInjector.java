package com.group3.createQuestion.DAO;

public class DAOMockInjector implements IDAOInjector {

    @Override
    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
        return new RetrieveQuestionTypesDAOMock();
    }
}
