package com.group3.createQuestion.DAO;

public class  DAOInjectorAbstractFactory {
    public static IDAOInjector getInstance(){
       return new DAOInjector();
    }
}
