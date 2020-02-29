package com.group3.createQuestion.DAO;

import java.util.ArrayList;
import java.util.List;

import com.group3.createQuestion.Services.IDeleteQuestionService;

public class RemoveQuestionDAOMock implements IRemoveQuestionDAO{

	List<List<String>> questionList;
	List<String> questionInfo;
	
	public RemoveQuestionDAOMock() {

		questionList = new ArrayList<List<String>>();
		questionInfo = new ArrayList<String>();
		questionInfo.add("1");
		questionInfo.add("Test Title 1");
		questionInfo.add("Test Text 1");
		questionList.add(questionInfo);
		questionInfo = new ArrayList<String>();
		questionInfo.add("2");
		questionInfo.add("Test Title 2");
		questionInfo.add("Test Text 2");
		questionList.add(questionInfo);
	}

	@Override
	public boolean removeQuestionFromDatabase(String questionID) {
		boolean result = false;
		for(int i=0;i<questionList.size();i++) {
			if(questionList.get(i).get(0).equals(questionID)) {
				questionList.remove(i);
				result=true;
				break;
			}
		}	
		return result;
	}
}
