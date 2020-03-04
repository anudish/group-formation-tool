package com.group3.createQuestion.Services;

public class MakeQuestionGenerationAbstractFactory implements IMakeQuestionGenerationAbstractFactory {

	@Override
	public IQuestionService makeQuestion(String questionType) {

		IQuestionService questionService = null;

		switch (questionType) {
			case "Free Text":
				questionService = new freeTextQuestionGenerationService();
				break;
			case "Numeric":
				questionService = new NumericQuestionGenerationService();
				break;
		}
		return questionService;
	}
}