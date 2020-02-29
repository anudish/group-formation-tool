package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ValidationRulesLoader {
    private static ValidationRulesLoader validationRulesLoader;
    private ArrayList<String> validationRules;
    private ArrayList<IStringValidatorService> enabledValidationServiceList;
    private Logger logger = LogManager.getLogger(ValidationRulesLoader.class);
    private ValidationRulesLoader(IValidationRulesLoaderDAO iValidationRulesLoaderDAO){
        validationRules = new ArrayList<>();
        enabledValidationServiceList = new ArrayList<>();
        validationRules = iValidationRulesLoaderDAO.getValidationRules();
        this.getValidationRules();
    }
    public static ValidationRulesLoader getInstance(IValidationRulesLoaderDAO iValidationRulesLoaderDAO){
        if (null == validationRulesLoader){
            validationRulesLoader = new ValidationRulesLoader(iValidationRulesLoaderDAO);
        }
        return validationRulesLoader;
    }
    private ArrayList<IStringValidatorService> getValidationRules(){

        for(String rule : validationRules){
            logger.info(rule);
            if (rule.equals(ValidationRulesEnumerator.CHECK_EMPTY_STRING.toString())){
                logger.info("enabling empty string checking..");
                enabledValidationServiceList.add(new EmptyStringValidationService());
            }
            else if(rule.equals(ValidationRulesEnumerator.CHECK_START_NUMERIC.toString())){
                logger.info("enabling starting numeric check service..");
                enabledValidationServiceList.add(new StartWithNumberCheckValidationService());
            }
            else if(rule.equals(ValidationRulesEnumerator.CHECK_START_SPECIAL_CHAR.toString())){
                logger.info("enabling special character check service..");
                enabledValidationServiceList.add(new StartWithSpecialSymbolValidationService());
            }
        }
        return enabledValidationServiceList;
    }
    public ArrayList<IStringValidatorService> returnValidationRules(){
        return enabledValidationServiceList;
    }
}
