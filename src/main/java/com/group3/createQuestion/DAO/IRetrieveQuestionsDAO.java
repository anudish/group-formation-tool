package com.group3.createQuestion.DAO;

import java.util.List;

import com.group3.createQuestion.BusinessModels.Question;

public interface IRetrieveQuestionsDAO {
	public List<List<String>> getQuestionsByInstructorID(String instructorId, String order);
}
