package com.group3.createQuestion.Services;

public class ObtainServiceFactoryInstance {
    public static IServiceAbstractFactory iServiceAbstractFactory;
    public static IServiceAbstractFactory getInstance(){
        if (null == iServiceAbstractFactory){
            iServiceAbstractFactory = new ServiceAbstractFactory();
        }
        return iServiceAbstractFactory;
    }


}
