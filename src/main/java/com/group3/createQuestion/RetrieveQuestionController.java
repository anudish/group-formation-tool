package com.group3.createQuestion;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Instructor;
import com.group3.createQuestion.DAO.*;
import com.group3.createQuestion.Services.*;
import com.group3.login.Services.LoginAuthenticationSuccessHandler;

@Controller
public class RetrieveQuestionController {

	private Logger logger = LogManager.getLogger(RetrieveQuestionController.class);

	IDAOAbstractFactory daoInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	IObtainQuestionsService obtainQuestionsService;

	public RetrieveQuestionController() {

		daoInjector = DAOAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		obtainQuestionsService = serviceAbstractFactory.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
	}

	@RequestMapping("/showAvailableQuestionsToDelete")
	public ModelAndView showDeletableQuestions() {
		List<List<String>> questionList;
		
		logger.info("Showing available questions that can be deleted");
		Instructor instructor = new Instructor();
		instructor.setEmail(LoginAuthenticationSuccessHandler.email);
		questionList = obtainQuestionsService.obtainInstructorQuestions(instructor, "");
		logger.info("Total Questions fetched: " + questionList.size());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("questionList", questionList);
		mv.setViewName("deleteQuestionPage.html");
		return mv;
	}

	@RequestMapping("/showAvailableQuestionsSorted")
	public ModelAndView showQuestionsSorted(@RequestParam String order, @RequestParam String mode) {
		List<List<String>> questionList;
		
		logger.info("Request to available questions in sorted manner!");
		logger.info("Order requested: " + order);
		Instructor instructor = new Instructor();
		instructor.setEmail(LoginAuthenticationSuccessHandler.email);
		questionList = obtainQuestionsService.obtainInstructorQuestions(instructor, order);
		logger.info("Total Questions fetched: " + questionList.size());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("questionList", questionList);
		mv.addObject("deleteQuery", mode);
		mv.setViewName("deleteQuestionPage.html");
		return mv;
	}

}