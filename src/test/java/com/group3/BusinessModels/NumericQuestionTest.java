package com.group3.BusinessModels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.BusinessModels.NumericQuestion;

class NumericQuestionTest {

	NumericQuestion num;
	
	@BeforeEach
	public void init() {
		num = new NumericQuestion();
	}
	
	@Test
	void addQuestionTest() {
		num.addQuestion("Test Title", "Test Text", "Test Type");
		assertTrue(num.getQuestionTitle().equals("Test Title"));
		assertTrue(num.getQuestionText().equals("Test Text"));
		assertTrue(num.getQuestionType().equals("Test Type"));
	}

}
