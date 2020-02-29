package com.group3.createQuestion.DAOTest;

import com.group3.createQuestion.DAO.DAOInjector;
import com.group3.createQuestion.DAO.IDAOInjector;

public class DAOInjectorAbstractFactory {
    public static IDAOInjector getInstance(){
       return new DAOInjector();
    }
}
