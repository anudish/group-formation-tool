package com.group3.createQuestion.BusinessModels;

import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

public abstract class Question {
    private static String questionTitle;
    private static String questionText;
    private static String questionType;

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public static String saveBasicInformationIntoDatabase(ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO,String questionTitle,String questionText,String questionType){
        String id = iSaveBasicQuestionInformationDAO.saveDetailsAndReturnId(questionTitle,questionText,questionType);
        String feedBackMessage = new String();
        if (id.length() > 0) {
            feedBackMessage = id;
        }
        return feedBackMessage;
    }
}
