package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;

import java.util.ArrayList;

public class StringValidatorService implements IStringValidatorService {

	private ArrayList<IStringValidatorService> enabledValidationServiceList;
	private IValidationRulesLoaderDAO validationRulesLoaderDAO;
	private ValidationRulesLoader validationRulesLoader;

	public StringValidatorService(IValidationRulesLoaderDAO validationRulesLoaderDAO) {

		this.validationRulesLoaderDAO = validationRulesLoaderDAO;
		validationRulesLoader = ValidationRulesLoader.instance(validationRulesLoaderDAO);
	}

	@Override
	public boolean isValid(String inputString) {

		enabledValidationServiceList = validationRulesLoader.returnValidationRules();

		for (IStringValidatorService stringValidatorService: enabledValidationServiceList) {
			if (!stringValidatorService.isValid(inputString)) {
				return false;
			}
		}
		return true;
	}
}