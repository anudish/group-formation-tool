package com.group3.createQuestion;


import com.group3.createQuestion.BusinessModels.questionTypes;
import com.group3.createQuestion.DAO.*;
import com.group3.createQuestion.Services.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class createQuestionController {

    private String title,question,type;
    Logger logger = LogManager.getLogger(createQuestionController.class);
    private ArrayList<questionTypes> questionTypesList;
    IDAOInjector idaoInjector;
    IServiceAbstractFactory iServiceAbstractFactory;
    ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO;
    ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService;
    public createQuestionController(){
        idaoInjector = DAOInjector.getInstance();
        iServiceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        iCurrentTimeStampGenerationService = iServiceAbstractFactory.createCurrentTimeStampGenerationService();
    }
    @RequestMapping("/requestQuestionPage")
    public String renderQuestionGenerationPage(Model model){
        logger.info("createQuestionController invocation");
        questionTypesList = new ArrayList<>();
        IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO = idaoInjector.createRetrieveQuestionTypesDAO();
        IObtainAllQuestionTypesService iObtainAllQuestionTypesService =  iServiceAbstractFactory.createObtainAllQuestionTypesService(iRetrieveQuestionTypesDAO);
        questionTypesList = iObtainAllQuestionTypesService.getAllQuestionTypes();
        logger.info("question types list length "+questionTypesList.size());
        model.addAttribute("questionTypesList",questionTypesList);
        return "mainQuestionPage.html";
    }

    @RequestMapping("/requestAnswerPage")
    public String renderAnswerPage(Model model, String questionTypeSelector, @RequestParam("title") String title,@RequestParam("question") String question){
        logger.info("response type :: " +questionTypeSelector);
        IValidationRulesLoaderDAO iValidationRulesLoaderDAO = idaoInjector.createValidationRulesLoaderDAO();
        IStringValidatorService iStringValidatorService = iServiceAbstractFactory.createStringValidatorService(iValidationRulesLoaderDAO);
        String controllerPath = new String();
        if (iStringValidatorService.isValid(title) && iStringValidatorService.isValid(question) && !questionTypeSelector.equalsIgnoreCase("Select Type")){
            logger.info("valid title and question after validation : "+title+" "+question);
            this.title = title;
            this.question = question;
            this.type = questionTypeSelector;
            IQuestionService iQuestionService = iServiceAbstractFactory.createMakeQuestionGenerationAbstractFactory().makeQuestion(questionTypeSelector);
            logger.info("Question Type decision from parent class :: "+iQuestionService.getQuestionType());
            IReturnControllerPathService iReturnControllerPathService = iServiceAbstractFactory.createReturnControllerPathService();
            controllerPath = iReturnControllerPathService.returnControllerPath(iQuestionService.getQuestionType());

            logger.info("Question Controller Path :: "+controllerPath);
        }

        return "redirect:/"+controllerPath;
    }
    @RequestMapping("/invokeFreeText")
    public String renderFreeTextAnswerPage(){
        logger.log(Level.INFO,"REQUEST FORWARDED TO INVOKE FREE TEXT QUESTION GENERATION CONTROLLER !! ");
        IQuestionService iQuestionService = iServiceAbstractFactory.createfreeTextQuestionGenerationService();

        iSaveBasicQuestionInformationDAO = idaoInjector.createSaveBasicQuestionInformationDAO(iCurrentTimeStampGenerationService);
        //iQuestionService.saveBasicQuestionInformation(title,question,type,iCurrentTimeStampGenerationService);
        String id = iQuestionService.saveBasicQuestionInformation(title,question,type,iSaveBasicQuestionInformationDAO);
        logger.log(Level.INFO,"Question id returned from database "+id);
        return "mainQuestionPage.html";
    }
}


