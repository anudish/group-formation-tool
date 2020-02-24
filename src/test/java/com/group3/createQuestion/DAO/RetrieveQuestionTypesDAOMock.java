package com.group3.createQuestion.DAO;

import com.group3.createQuestion.BusinessModels.questionTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class RetrieveQuestionTypesDAOMock implements IRetrieveQuestionTypesDAO {
    ArrayList<questionTypes> questionTypesList;
    public static Logger logger = LogManager.getLogger(RetrieveQuestionTypesDAOMock.class);
    @Override
    public ArrayList<questionTypes> getQuestionTypes() {
        //Generate Mock Data
        logger.info("inside RetrieveQuestionTypesDAO Mock function ");
        questionTypes questionType;
        questionTypesList = new ArrayList<>();
        questionType = new questionTypes();
        questionType.setQuestionType("Multiple Choice, Choose One");
        questionTypesList.add(questionType);
        questionType = new questionTypes();
        questionType.setQuestionType("Multiple Choice, Choose Multiple");
        questionTypesList.add(questionType);
        questionType = new questionTypes();
        questionType.setQuestionType("Free Text");
        questionTypesList.add(questionType);
        questionType = new questionTypes();
        questionType.setQuestionType("Numeric");
        questionTypesList.add(questionType);
        return questionTypesList;
    }
}
