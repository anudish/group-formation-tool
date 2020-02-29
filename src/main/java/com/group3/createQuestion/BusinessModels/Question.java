package com.group3.createQuestion.BusinessModels;

import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

public abstract class Question {
    private String questionTitle;
    private String questionText;
    private String questionType;

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

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
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
