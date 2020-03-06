package com.group3.course.DAO;

import com.group3.course.DAO.*;

public interface IDAOAbstractFactory {
	public ICourseDAO createCourseDAO();

	public IStudentDAO createStudentDAO();

	public ITADAO createTADAO();

	public IInstructorDAO createInstructorDAO();
}