package com.group3.createQuestion.DAO;

import com.group3.createQuestion.BusinessModels.Question;
import com.group3.createQuestion.BusinessModels.questionTypes;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRetrieveQuestionTypesDAO {
    ArrayList<questionTypes> getQuestionTypes();
}
