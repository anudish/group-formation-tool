package com.group3.DAO;

public class DAOMockInjector implements IDAOInjector {
	@Override
	public ICourseDAO createCourseDAO() {
		return new CourseDAOMock();
	}
	
	@Override
	public IStudentDAO createStudentDAO() {
		return new StudentDAOMock();
	}

	@Override
	public ITADAO createTADAO() {
		return new TADAOMock();
	}

	@Override
	public IInstructorDAO createInstructorDAO() {
		return new InstructorDAOMock();
	}
	
}
