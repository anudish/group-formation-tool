package com.group3.createQuestion;


import com.group3.BusinessModels.Instructor;
import com.group3.createQuestion.DAO.DAOInjectorAbstractFactory;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.Services.IDeleteQuestionService;
import com.group3.createQuestion.Services.IObtainQuestionsService;
import com.group3.createQuestion.Services.IServiceAbstractFactory;
import com.group3.createQuestion.Services.ObtainServiceFactoryInstance;
import com.group3.createQuestion.Services.ServiceAbstractFactory;
import com.group3.login.LoginAuthenticationSuccessHandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//Krutarth

@Controller
public class DeleteQuestionController {
    Logger logger = LogManager.getLogger(DeleteQuestionController.class);

    IDAOInjector daoInjector;
    IServiceAbstractFactory serviceAbstractFactory;
    IDeleteQuestionService deleteQuestionService;
    IObtainQuestionsService obtainQuestionsService;
    
    public DeleteQuestionController() {
    	daoInjector = DAOInjectorAbstractFactory.getInstance();
        serviceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        deleteQuestionService = serviceAbstractFactory.createDeleteQuestionService(daoInjector.createRemoveQuestionDAO());
        obtainQuestionsService = serviceAbstractFactory.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
    }
    
    @RequestMapping("/deleteQuestion")
    public ModelAndView deleteQuestion(@RequestParam String questionId){
    	
        logger.info("Question to be deleted: "+questionId);
        deleteQuestionService.deleteQuestionByQuestionId(questionId);
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
