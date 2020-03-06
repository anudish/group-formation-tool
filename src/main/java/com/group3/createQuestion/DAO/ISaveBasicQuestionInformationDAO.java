package com.group3.createQuestion.DAO;

public interface ISaveBasicQuestionInformationDAO {
	String saveDetailsAndReturnId(String title, String text, String type);
}
