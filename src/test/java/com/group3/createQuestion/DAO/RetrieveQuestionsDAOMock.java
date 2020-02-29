package com.group3.createQuestion.DAO;

import java.util.ArrayList;
import java.util.List;

public class RetrieveQuestionsDAOMock implements IRetrieveQuestionsDAO {

	List<List<String>> questionList;
	List<String> questionInfo;
	
	@Override
	public List<List<String>> getQuestionsByInstructorID(String instructorId) {
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
		return questionList;
	}

}
