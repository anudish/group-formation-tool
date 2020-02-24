package com.group3.createQuestion.DAO;

public class DAOInjector implements IDAOInjector {

    @Override
    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
        return new RetrieveQuestionTypesDAO();
    }

    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAOMock(){ return new RetrieveQuestionTypesDAOMock();}
}
