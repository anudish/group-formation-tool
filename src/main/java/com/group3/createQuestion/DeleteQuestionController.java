package com.group3.createQuestion;


import com.group3.BusinessModels.Instructor;
import com.group3.createQuestion.DAO.*;
import com.group3.createQuestion.Services.*;
import com.group3.login.Services.LoginAuthenticationSuccessHandler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteQuestionController {

	IDAOAbstractFactory daoInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	IDeleteQuestionService deleteQuestionService;
	IObtainQuestionsService obtainQuestionsService;

	private Logger logger = LogManager.getLogger(DeleteQuestionController.class);

	public DeleteQuestionController() {

		daoInjector = DAOAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		deleteQuestionService = serviceAbstractFactory.createDeleteQuestionService(daoInjector.createRemoveQuestionDAO());
		obtainQuestionsService = serviceAbstractFactory.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
	}

	@RequestMapping("/deleteQuestion")
	public ModelAndView deleteQuestion(@RequestParam String questionId) {
		List<List<String>> questionList;

		logger.info("Question to be deleted: " + questionId);
		deleteQuestionService.deleteQuestionByQuestionId(questionId);
		Instructor instructor = new Instructor();
		instructor.setEmail(LoginAuthenticationSuccessHandler.email);
		questionList = obtainQuestionsService.obtainInstructorQuestions(instructor, "");
		logger.info("Total Questions fetched: " + questionList.size());

		ModelAndView mv = new ModelAndView();
		mv.addObject("questionList", questionList);
		mv.addObject("deleteQuery", "visible");
		mv.setViewName("deleteQuestionPage.html");
		return mv;
	}
}