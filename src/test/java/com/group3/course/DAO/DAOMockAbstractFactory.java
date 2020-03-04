package com.group3.course.DAO;

import com.group3.course.DAO.*;

public class DAOMockAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory daoInjector;
	public static ICourseDAO courseDAO;
	public static IStudentDAO studentDAO;
	public static ITADAO taDAO;
	public static IInstructorDAO instructorDAO;

	public static IDAOAbstractFactory instance() {
		if (null == daoInjector) {
			daoInjector = new DAOMockAbstractFactory();
		}
		return daoInjector;
	}

	@Override
	public ICourseDAO createCourseDAO() {
		if (null == courseDAO) {
			courseDAO = new CourseDAOMock();
		}
		return courseDAO;
	}

	@Override
	public IStudentDAO createStudentDAO() {
		if (null == studentDAO) {
			studentDAO = new StudentDAOMock();
		}
		return studentDAO;
	}

	@Override
	public ITADAO createTADAO() {
		if (null == taDAO) {
			taDAO = new TADAOMock();
		}
		return taDAO;
	}

	@Override
	public IInstructorDAO createInstructorDAO() {
		if (null == instructorDAO) {
			instructorDAO = new InstructorDAOMock();
		}
		return instructorDAO;
	}
}