package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.DAOInjector;

public class  DAOInjectorAbstractFactory {
    public static IDAOInjector getInstance(){
       return new DAOInjector();
    }
}
