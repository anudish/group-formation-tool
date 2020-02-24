package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.questionTypes;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;

import java.util.ArrayList;

public class ObtainAllQuestionTypesService implements IObtainAllQuestionTypesService {
    private IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO;
    private ArrayList<questionTypes> questionTypes;
    public ObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO){
        this.iRetrieveQuestionTypesDAO = iRetrieveQuestionTypesDAO;

    }
    @Override
    public ArrayList<questionTypes> getAllQuestionTypes() {
        questionTypes = this.iRetrieveQuestionTypesDAO.getQuestionTypes();
        return questionTypes;
    }
}
