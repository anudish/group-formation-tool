package com.group3.DAO;

public class DAOInjector implements IDAOInjector {

	@Override
	public ICourseDAO createCourseDAO() {
		return new CourseDAO();
	}
	
	@Override
	public IStudentDAO createStudentDAO() {
		return new StudentDAO();
	}
	@Override
	public IUserDAO createUserDAO() {
		return new UserDAO();
	}

	@Override
	public LoginDao createLoginDAO() {
		return new LoginDao();
	}
}
