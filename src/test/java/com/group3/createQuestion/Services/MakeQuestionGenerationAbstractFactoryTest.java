package com.group3.createQuestion.Services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeQuestionGenerationAbstractFactoryTest {
    private IMakeQuestionGenerationAbstractFactory iMakeQuestionGenerationAbstractFactory;
    private IQuestionService iQuestionService;
    @BeforeEach
    void setUp() {
        iMakeQuestionGenerationAbstractFactory = ObtainServiceFactoryInstance.getInstance().createMakeQuestionGenerationAbstractFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void makeQuestion() {
        iQuestionService = iMakeQuestionGenerationAbstractFactory.makeQuestion("Free Text");
        assertTrue(iQuestionService instanceof freeTextQuestionGenerationService);
    }
}