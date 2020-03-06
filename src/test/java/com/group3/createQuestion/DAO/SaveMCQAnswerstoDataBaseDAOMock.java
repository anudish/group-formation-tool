package com.group3.createQuestion.DAO;

import java.util.ArrayList;

import com.group3.createQuestion.BusinessModels.MCQAnswers;

public class SaveMCQAnswerstoDataBaseDAOMock implements ISaveMCQAnswerstoDataBaseDAO{

	@Override
	public int saveOptionsToDataBase(int id, ArrayList<MCQAnswers> mcqAnswers) {
		return 1;
	}

}
