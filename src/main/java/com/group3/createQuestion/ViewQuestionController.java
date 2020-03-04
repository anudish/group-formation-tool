package com.group3.createQuestion;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Instructor;
import com.group3.createQuestion.DAO.*;
import com.group3.createQuestion.Services.*;
import com.group3.login.Services.LoginAuthenticationSuccessHandler;

@Controller
public class ViewQuestionController {
	Logger logger = LogManager.getLogger(ViewQuestionController.class);

    IDAOAbstractFactory daoInjector;
    IServiceAbstractFactory serviceAbstractFactory;
    IObtainQuestionsService obtainQuestionsService;
    
    public ViewQuestionController() {
    	
    	daoInjector = DAOAbstractFactory.instance();
    	serviceAbstractFactory = ServiceAbstractFactory.instance();
        obtainQuestionsService = serviceAbstractFactory.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
    }
    
    @RequestMapping("/viewQuestions")
    public ModelAndView viewQuestions(){
    	List<List<String>> questionList;
    	
    	logger.info("Fetching the available questions!");
        Instructor instructor = new Instructor();
        instructor.setEmail(LoginAuthenticationSuccessHandler.email);
        questionList = obtainQuestionsService.obtainInstructorQuestions(instructor,"");
        logger.info("Total Questions fetched: "+questionList.size());
        
        ModelAndView mv = new ModelAndView();
		mv.addObject("questionList",questionList);
		mv.addObject("deleteQuery","hidden");
		mv.setViewName("deleteQuestionPage.html");
		return mv;
    }
}
