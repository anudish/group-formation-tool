package com.group3.DAO;

import java.util.ArrayList;

public interface IInstructorHandlerDAO {
	String createNewInstructor(String MailId, String CourseId);
	boolean isInstructorExists(String MailId);
    String deleteinstructor(String MailId);
    ArrayList<String> getInstructorCourses(String MaildId);
}
