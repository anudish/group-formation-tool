package com.group3.createQuestion;


import com.group3.createQuestion.DAO.DAOInjectorAbstractFactory;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.Services.IServiceAbstractFactory;
import com.group3.createQuestion.Services.ObtainServiceFactoryInstance;
import com.group3.createQuestion.Services.ServiceAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class createQuestionController {
    Logger logger = LogManager.getLogger(createQuestionController.class);

    @RequestMapping("/requestQuestionPage")
    public String renderQuestionGenerationPage(){
        logger.info("createQuestionController invocation");

        IDAOInjector idaoInjector = DAOInjectorAbstractFactory.getInstance();
        IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO = idaoInjector.createRetrieveQuestionTypesDAO();
        IServiceAbstractFactory iServiceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        iServiceAbstractFactory.createObtainAllQuestionTypesService(iRetrieveQuestionTypesDAO);
        return "mainQuestionPage.html";
    }
}
