package com.group3.CreateQuestion;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Instructor;
import com.group3.CreateQuestion.DAO.DAOAbstractFactory;
import com.group3.CreateQuestion.DAO.IDAOAbstractFactory;
import com.group3.CreateQuestion.Services.IDeleteQuestionService;
import com.group3.CreateQuestion.Services.IObtainQuestionsService;
import com.group3.CreateQuestion.Services.IServiceAbstractFactory;
import com.group3.CreateQuestion.Services.ServiceAbstractFactory;
import com.group3.Login.Services.LoginAuthenticationSuccessHandler;

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
		deleteQuestionService = serviceAbstractFactory
				.createDeleteQuestionService(daoInjector.createRemoveQuestionDAO());
		obtainQuestionsService = serviceAbstractFactory
				.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
	}

	@RequestMapping("/deleteQuestion")
	public ModelAndView deleteQuestion(@RequestParam String questionId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

		List<List<String>> questionList;
		ModelAndView mv = new ModelAndView();

		logger.info("Question to be deleted: " + questionId);
		try {
			deleteQuestionService.deleteQuestionByQuestionId(questionId);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String email = authentication.getName();
			Instructor instructor = new Instructor();
			instructor.setEmail(email);

			questionList = obtainQuestionsService.obtainInstructorQuestions(instructor, "");
			logger.info("Total Questions fetched: " + questionList.size());

			mv.addObject("questionList", questionList);
			mv.addObject("deleteQuery", "visible");
			mv.setViewName("deleteQuestionPage.html");
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			mv.setViewName("error.html");
		} catch (IndexOutOfBoundsException ind) {
			logger.error(ind.getMessage());
			mv.setViewName("error.html");
		}
		return mv;
	}
}