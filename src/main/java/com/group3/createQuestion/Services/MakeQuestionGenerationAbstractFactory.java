package com.group3.createQuestion.Services;



public class MakeQuestionGenerationAbstractFactory implements IMakeQuestionGenerationAbstractFactory {
    public MakeQuestionGenerationAbstractFactory(){

    }
    @Override
    public  IQuestionService makeQuestion(String questionType) {


        IQuestionService iQuestionService = null;
        switch (questionType){
            case "Free Text":
                iQuestionService =  new freeTextQuestionGenerationService();
            break;

        }

        return iQuestionService;
    }
}
