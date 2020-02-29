package com.group3.createQuestion.Services;

public interface IMakeQuestionGenerationAbstractFactory {
    public  IQuestionService makeQuestion(String questionType);
}
