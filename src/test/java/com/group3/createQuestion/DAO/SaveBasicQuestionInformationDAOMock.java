package com.group3.createQuestion.DAO;

import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

import java.util.ArrayList;
import java.util.Random;

public class SaveBasicQuestionInformationDAOMock implements ISaveBasicQuestionInformationDAO {
    ICurrentTimeStampGenerationService currentTimeStampGenerationService;
    public SaveBasicQuestionInformationDAOMock(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService) {
        this.currentTimeStampGenerationService = iCurrentTimeStampGenerationService;
    }

    @Override
    public String saveDetailsAndReturnId(String title, String text, String type) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        String id = String.valueOf(randomNumber);
        return id;
    }

}
