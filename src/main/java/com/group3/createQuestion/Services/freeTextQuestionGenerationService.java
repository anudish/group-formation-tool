package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

public class freeTextQuestionGenerationService extends QuestionService{
    private String title,question;
    private ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO;
    public freeTextQuestionGenerationService(){
        super(QuestionGenerationServicesEnum.FREE_TEXT);
    }
    public String saveFreeTextQuestionGenerationServiceInfo(String title, String question,String type, ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO){
        String feedbackMessage = super.saveBasicQuestionInformation(title,question,type,iSaveBasicQuestionInformationDAO);
        return feedbackMessage;
    }
}
