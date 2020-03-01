package com.group3.createQuestion.DAO;

import com.group3.createQuestion.DAO.DAOInjector;

public class DAOInjectorAbstractFactory {
	
	static IDAOInjector daoInjector;
	
    public static IDAOInjector getInstance(){
       if(daoInjector == null) {
    	   daoInjector = new DAOInjector();
       }
    	return daoInjector;
    }
}
