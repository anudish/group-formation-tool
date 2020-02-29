package com.group3.createQuestion.BusinessModels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.BusinessModels.TextQuestion;

class TextQuestionTest {

	TextQuestion text;
	
	@BeforeEach
	public void init() {
		text = new TextQuestion();
	}
	
	@Test
	void addQuestionTest() {
		text.addQuestion("Test Title", "Test Text", "Test Type");
		assertTrue(text.getQuestionTitle().equals("Test Title"));
		assertTrue(text.getQuestionText().equals("Test Text"));
		assertTrue(text.getQuestionType().equals("Test Type"));
	}

}
