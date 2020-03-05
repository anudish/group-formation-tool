package com.group3.createQuestion.DAO;

import com.group3.createQuestion.BusinessModels.MCQAnswers;

import java.util.ArrayList;

public interface ISaveMCQAnswerstoDataBaseDAO {
    int saveOptionsToDataBase(int id, ArrayList<MCQAnswers> mcqAnswers);
}
