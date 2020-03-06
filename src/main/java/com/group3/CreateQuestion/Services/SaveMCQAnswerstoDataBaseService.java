package com.group3.CreateQuestion.Services;

import com.group3.CreateQuestion.BusinessModels.MCQAnswers;
import com.group3.CreateQuestion.DAO.ISaveMCQAnswerstoDataBaseDAO;

import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveMCQAnswerstoDataBaseService  extends QuestionService  {
	public static Logger logger = LogManager.getLogger(SaveMCQAnswerstoDataBaseService.class);
	public SaveMCQAnswerstoDataBaseService(){
        super(QuestionGenerationServicesEnum.MCQS_ONE);
    }

	public int saveMCQAnswertoDataBase(ISaveMCQAnswerstoDataBaseDAO saveMCQAnswerstoDataBaseDAO, int questionId,
			ArrayList<MCQAnswers> mcqAnswers) {
		int success=0;
    	try {
		success = saveMCQAnswerstoDataBaseDAO.saveOptionsToDataBase(questionId, mcqAnswers);
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		}
		return success;
	}
}
