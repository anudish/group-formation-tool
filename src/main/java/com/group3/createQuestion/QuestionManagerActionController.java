package com.group3.createQuestion;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Krutarth

@Controller
public class QuestionManagerActionController {

    Logger logger = LogManager.getLogger(QuestionManagerActionController.class);
    
    @RequestMapping("/QuestionManager")
    public String renderQuestionGenerationPage(){
    	
        logger.info("QuestionManager Request Triggered!");
        return "QuestionManager.html";
    }
    
}
