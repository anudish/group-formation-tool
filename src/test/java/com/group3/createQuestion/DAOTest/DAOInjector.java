package com.group3.createQuestion.DAOTest;

import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;
import com.group3.createQuestion.DAO.RetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.SaveBasicQuestionInformationDAO;
import com.group3.createQuestion.DAO.ValidationRulesLoaderDAO;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

public class DAOInjector implements IDAOInjector {

 
    @Override
    public IRetrieveQuestionTypesDAO createRetrieveQuestionTypesDAO() {
        return new RetrieveQuestionTypesDAO();
    }

    @Override
    public ISaveBasicQuestionInformationDAO createSaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService) {
        return new SaveBasicQuestionInformationDAO(iCurrentTimeStampGenerationService);
    }

    @Override
    public IValidationRulesLoaderDAO createValidationRulesLoaderDAO() {
        return new ValidationRulesLoaderDAO();
    }
}
