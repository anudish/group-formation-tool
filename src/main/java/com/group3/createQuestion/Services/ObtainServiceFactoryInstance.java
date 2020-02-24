package com.group3.createQuestion.Services;

public class ObtainServiceFactoryInstance {
    public static IServiceAbstractFactory getInstance(){
        return new ServiceAbstractFactory();
    }
}
