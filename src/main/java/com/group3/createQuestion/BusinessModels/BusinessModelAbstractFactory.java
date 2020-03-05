package com.group3.createQuestion.BusinessModels;

import com.group3.createQuestion.BusinessModels.IBusinessModelAbstractFactory;
import com.group3.createQuestion.BusinessModels.MCQAnswers;

public class BusinessModelAbstractFactory implements IBusinessModelAbstractFactory {
    private static BusinessModelAbstractFactory businessModelAbstractFactory;
    private BusinessModelAbstractFactory(){}
    public static BusinessModelAbstractFactory instance(){
        if (null == businessModelAbstractFactory){
            businessModelAbstractFactory =  new BusinessModelAbstractFactory();
        }
        return businessModelAbstractFactory;
    }
    @Override
    public MCQAnswers createMCQSAnswers() {
        return new MCQAnswers();
    }
}
