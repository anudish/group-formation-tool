package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

public interface IQuestionService {
    String saveBasicQuestionInformation(String questionTitle, String questionText,String questionType, ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO);
    QuestionGenerationServicesEnum getQuestionType();
}
