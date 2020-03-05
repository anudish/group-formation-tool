package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IRemoveQuestionDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;

public class ServiceAbstractFactory implements IServiceAbstractFactory {

	public static IServiceAbstractFactory serviceAbstractFactory;
	public static IObtainQuestionsService obtainQuestionsService;
	public static IDeleteQuestionService deleteQuestionService;
	public static IObtainAllQuestionTypesService obtainAllQuestionTypesService;
	public static ICurrentTimeStampGenerationService currentTimeStampGenerationService;
	public static IStringValidatorService stringValidatorService;
	public static IMakeQuestionGenerationAbstractFactory makeQuestionGenerationAbstractFactory;
	public static IReturnControllerPathService returnControllerPathService;
	public static IValidationRulesLoaderDAO validationRulesLoaderDAO;
	public static IQuestionService questionText;
	public static IQuestionService questionNumeric;

	public static IServiceAbstractFactory instance() {
		if (null == serviceAbstractFactory) {
			serviceAbstractFactory = new ServiceAbstractFactory();
		}
		return serviceAbstractFactory;
	}

	@Override
	public IObtainAllQuestionTypesService createObtainAllQuestionTypesService(IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO) {
		if (null == obtainAllQuestionTypesService) {
			obtainAllQuestionTypesService = new ObtainAllQuestionTypesService(retrieveQuestionTypesDAO);
		}
		return obtainAllQuestionTypesService;
	}

	@Override
	public ICurrentTimeStampGenerationService createCurrentTimeStampGenerationService() {
		if (null == currentTimeStampGenerationService) {
			currentTimeStampGenerationService = new CurrentTimeStampGenerationService();
		}
		return currentTimeStampGenerationService;

	}

	@Override
	public IStringValidatorService createStringValidatorService(IValidationRulesLoaderDAO validationRulesLoaderDAO) {
		if (null == stringValidatorService) {
			stringValidatorService = new StringValidatorService(validationRulesLoaderDAO);
		}
		return stringValidatorService;
	}

	@Override
	public IMakeQuestionGenerationAbstractFactory createMakeQuestionGenerationAbstractFactory() {
		if (null == makeQuestionGenerationAbstractFactory) {
			makeQuestionGenerationAbstractFactory = new MakeQuestionGenerationAbstractFactory();
		}
		return makeQuestionGenerationAbstractFactory;
	}

	@Override
	public IReturnControllerPathService createReturnControllerPathService() {
		if (null == returnControllerPathService) {
			returnControllerPathService = new ReturnControllerPathService();
		}
		return returnControllerPathService;
	}

	@Override
	public IQuestionService createfreeTextQuestionGenerationService() {
		if (null == questionText) {
			questionText = new FreeTextQuestionGenerationService();
		}
		return questionText;
	}

	@Override
	public IQuestionService createNumericQuestionGenerationService() {
		if (null == questionNumeric) {
			questionNumeric = new NumericQuestionGenerationService();
		}
		return questionNumeric;
	}

	@Override
	public IObtainQuestionsService createObtainQuestionsService(IRetrieveQuestionsDAO retrieveQuestionDAO) {
		if (obtainQuestionsService == null) {
			obtainQuestionsService = new ObtainQuestionsService(retrieveQuestionDAO);
		}
		return obtainQuestionsService;
	}

	@Override
	public IDeleteQuestionService createDeleteQuestionService(IRemoveQuestionDAO removeQuestionDAO) {
		if (deleteQuestionService == null) {
			deleteQuestionService = new DeleteQuestionService(removeQuestionDAO);
		}
		return deleteQuestionService;
	}

    @Override
    public ISplitMCQSAnswerService createSplitMCQSAnswerService() {
        return SplitMCQSAnswerService.instance();
    }

    @Override
    public IQuestionService createSaveMCQAnswerstoDataBaseService() {
        return new SaveMCQAnswerstoDataBaseService();
    }

}