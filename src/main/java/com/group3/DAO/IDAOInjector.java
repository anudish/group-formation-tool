package com.group3.DAO;

public interface IDAOInjector {
	
	public ICourseDAO createCourseDAO();
	public IStudentDAO createStudentDAO();
	public IUserDAO createUserDAO();
	
	public LoginDao createLoginDAO();

}
