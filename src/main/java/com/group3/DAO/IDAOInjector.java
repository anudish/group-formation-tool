package com.group3.DAO;

public interface IDAOInjector {
	
	public ICourseDAO createCourseDAO();
	public IStudentDAO createStudentDAO();
	public ITADAO createTADAO();
	public IInstructorDAO createInstructorDAO();

}
