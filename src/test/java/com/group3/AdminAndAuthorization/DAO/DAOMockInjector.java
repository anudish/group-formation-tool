package com.group3.AdminAndAuthorization.DAO;

import com.group3.AdminAndAuthorization.DAO.IDAOInjector;

import com.group3.AdminAndAuthorization.DAO.*;

public class DAOMockInjector implements IDAOInjector {
	IAddCourseDAO addCourseDAO;
	IViewCoursesDAO viewCoursesDAO;
	IDeleteCourseDAO deleteCourseDAO;
	IGrantInstructorAccessDAO grantInstructorAccessDAO;
	IInstructorHandlerDAO instructorHandlerDAO;
	IUserRoleHandlerDAO userRoleHandlerDAO;

	@Override
	public IAddCourseDAO createAddCourseDAO() {
		if (null == addCourseDAO) {
			addCourseDAO = new AddCourseDAOMock();
		}

		return addCourseDAO;
	}

	@Override
	public IViewCoursesDAO createViewCourseDAO() {
		return new ViewCoursesDAOMock();
	}

	@Override
	public IDeleteCourseDAO createDeleteCourseDAO() {
		return new DeleteCourseDAOMock();
	}

	@Override
	public IGrantInstructorAccessDAO createGrantInstructorAccessDAO() {
		return new GrantInstructorAccessDAOMock();
	}

	@Override
	public IInstructorHandlerDAO createInstructorHandlerDAO() {
		return new InstructorHandlerDAOMock();
	}

	@Override
	public IUserRoleHandlerDAO createUserRoleHandlerDAO() {
		return new UserRoleHandlerDAOMock();
	}
}