package com.group3.createQuestion.Services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.DAO.DAOMockInjector;

import static org.junit.jupiter.api.Assertions.*;

class MakeQuestionGenerationAbstractFactoryTest {

	IServiceAbstractFactory serviceAbstractFactory;
	IMakeQuestionGenerationAbstractFactory makeQuestionGenerationAbstractFactory;
	IQuestionService questionService;

	@BeforeEach
	void setUp() {

		serviceAbstractFactory = ServiceAbstractFactory.instance();
		makeQuestionGenerationAbstractFactory = serviceAbstractFactory.createMakeQuestionGenerationAbstractFactory();
	}

	@Test
	void makeQuestion() {

		questionService = makeQuestionGenerationAbstractFactory.makeQuestion("Free Text");
		assertTrue(questionService instanceof freeTextQuestionGenerationService);
	}
}