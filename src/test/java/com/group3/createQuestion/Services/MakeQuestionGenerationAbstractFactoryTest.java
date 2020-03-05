package com.group3.createQuestion.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertTrue(questionService instanceof FreeTextQuestionGenerationService);
	}
}