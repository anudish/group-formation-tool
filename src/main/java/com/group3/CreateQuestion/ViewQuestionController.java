package com.group3.CreateQuestion;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Instructor;
import com.group3.CreateQuestion.DAO.DAOAbstractFactory;
import com.group3.CreateQuestion.DAO.IDAOAbstractFactory;
import com.group3.CreateQuestion.Services.IObtainQuestionsService;
import com.group3.CreateQuestion.Services.IServiceAbstractFactory;
import com.group3.CreateQuestion.Services.ServiceAbstractFactory;


@Controller
public class ViewQuestionController {
	IDAOAbstractFactory daoInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	IObtainQuestionsService obtainQuestionsService;

	private Logger logger = LogManager.getLogger(ViewQuestionController.class);

	public ViewQuestionController() {

		daoInjector = DAOAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		obtainQuestionsService = serviceAbstractFactory
				.createObtainQuestionsService(daoInjector.createRetrieveQuestionsDAO());
	}

	@RequestMapping("/viewQuestions")
	public ModelAndView viewQuestions() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		List<List<String>> questionList;

		logger.info("Fetching the available questions!");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String email = authentication.getName();
		Instructor instructor = new Instructor();
        ModelAndView mv = new ModelAndView();
        try {
		instructor.setEmail(email);
		questionList = obtainQuestionsService.obtainInstructorQuestions(instructor, "");
		logger.info("Total Questions fetched: " + questionList.size());

				mv.addObject("questionList", questionList);
		mv.addObject("deleteQuery", "hidden");
		mv.setViewName("deleteQuestionPage.html");
		} catch (NullPointerException e) {
			mv.setViewName("error.html");
		}
		return mv;
	}
}
