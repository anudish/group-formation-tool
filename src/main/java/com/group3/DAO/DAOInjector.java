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
	public ITADAO createTADAO() {
		return new TADAO();
	}
	
	@Override
	public IInstructorDAO createInstructorDAO() {
		return new InstructorDAO();
	}
}
