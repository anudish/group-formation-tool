package com.group3.CreateQuestion;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionManagerActionController {

	private Logger logger = LogManager.getLogger(QuestionManagerActionController.class);

	@RequestMapping("/QuestionManager")
	public String renderQuestionGenerationPage() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
		logger.info("QuestionManager Request Triggered!");
		return "QuestionManager.html";
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return "error.html";
	}
    }
}
