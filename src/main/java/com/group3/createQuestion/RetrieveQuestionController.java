package com.group3.createQuestion;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Instructor;
import com.group3.createQuestion.DAO.DAOInjectorAbstractFactory;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;
import com.group3.createQuestion.Services.IObtainQuestionsService;
import com.group3.createQuestion.Services.IServiceAbstractFactory;
import com.group3.createQuestion.Services.ObtainServiceFactoryInstance;
import com.group3.login.LoginAuthenticationSuccessHandler;

//Krutarth

@Controller
public class RetrieveQuestionController {

	Logger logger = LogManager.getLogger(RetrieveQuestionController.class);
    
	IDAOInjector daoInjector;
    IServiceAbstractFactory serviceAbstractFactory;
    IObtainQuestionsService obtainQuestionsService;
    
    public RetrieveQuestionController() {
    	daoInjector = DAOInjectorAbstractFactory.getInstance();
        serviceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        obtainQuestionsService = serviceAbstractFactory.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
    }
    
    @RequestMapping("/showAvailableQuestionsToDelete")
    public ModelAndView showDeletableQuestions(){
    	
        logger.info("Showing available questions that can be deleted");
        Instructor instructor = new Instructor();
        instructor.setEmail(LoginAuthenticationSuccessHandler.email);
        List<List<String>> questionList = obtainQuestionsService.obtainInstructorQuestions(instructor);
        logger.info("Total Questions fetched: "+questionList.size());
        ModelAndView mv = new ModelAndView();
		mv.addObject("questionList",questionList);
		mv.setViewName("deleteQuestionPage.html");
		return mv;
    }
	
}
