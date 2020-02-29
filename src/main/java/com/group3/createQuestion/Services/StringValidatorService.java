package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;

import java.util.ArrayList;

public class StringValidatorService implements IStringValidatorService {
    private ArrayList<IStringValidatorService> enabledValidationServiceList;
    private IValidationRulesLoaderDAO iValidationRulesLoaderDAO;
    private ValidationRulesLoader validationRulesLoader;
    public StringValidatorService(IValidationRulesLoaderDAO iValidationRulesLoaderDAO){
        this.iValidationRulesLoaderDAO = iValidationRulesLoaderDAO;
        validationRulesLoader = ValidationRulesLoader.getInstance(iValidationRulesLoaderDAO);
    }
    @Override
    public boolean isValid(String inputString) {
        enabledValidationServiceList = validationRulesLoader.returnValidationRules();
        for(IStringValidatorService stringValidatorService:enabledValidationServiceList){
            if(!stringValidatorService.isValid(inputString)){
                return false;
            }
        }
        return true;
    }
}
