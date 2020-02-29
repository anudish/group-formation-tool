package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.questionTypes;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAOTest.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ObtainAllQuestionTypesServiceTest {
    private IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO;
    private IObtainAllQuestionTypesService iObtainAllQuestionTypesService;
    private IServiceAbstractFactory iServiceAbstractFactory;
    ArrayList<questionTypes> questionTypes;
    public static Logger logger = LogManager.getLogger(ObtainAllQuestionTypesServiceTest.class);
    @BeforeEach
    void setUp() {
        questionTypes = new ArrayList<>();
        IDAOInjector daoInjector = DAOMockInjectorAbstractFactory.getInstance();
        iRetrieveQuestionTypesDAO = daoInjector.createRetrieveQuestionTypesDAO();
        logger.info(iRetrieveQuestionTypesDAO.getQuestionTypes().size());
        iServiceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        iObtainAllQuestionTypesService = iServiceAbstractFactory.createObtainAllQuestionTypesService(iRetrieveQuestionTypesDAO);
        questionTypes = iObtainAllQuestionTypesService.getAllQuestionTypes();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllQuestionTypes() {
        assertTrue(questionTypes.size() > 0);
        assertFalse(questionTypes.size() == 0);

    }
}