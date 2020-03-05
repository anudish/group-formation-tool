package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.MCQAnswers;

import java.util.ArrayList;

public interface ISplitMCQSAnswerService {
    public ArrayList<MCQAnswers> splitAnswers(MCQAnswers mcqAnswers);
}
