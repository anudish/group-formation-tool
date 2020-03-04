package com.group3.createQuestion.Services;

import java.util.List;

import com.group3.BusinessModels.Instructor;
import com.group3.createQuestion.BusinessModels.Question;

public interface IObtainQuestionsService {
	public List<List<String>> obtainInstructorQuestions(Instructor instructor, String order);
}
