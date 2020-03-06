package com.group3.AdminAndAuthorization.DAO;

import com.group3.AdminAndAuthorization.DAO.IDAOInjector;

import com.group3.AdminAndAuthorization.DAO.*;

public class DAOMockInjector implements IDAOInjector
{
	IAddCourseDAO addCourseDAO;
	IViewCoursesDAO viewCoursesDAO;
	IDeleteCourseDAO deleteCourseDAO;
	IGrantInstructorAccessDAO grantInstructorAccessDAO;
	IInstructorHandlerDAO instructorHandlerDAO;
	IUserRoleHandlerDAO userRoleHandlerDAO;

	@Override
	public IAddCourseDAO createAddCourseDAO()
	{
		if (null == addCourseDAO)
		{
			addCourseDAO = new AddCourseDAOMock();
		}

		return addCourseDAO;
	}

	@Override
	public IViewCoursesDAO createViewCourseDAO()
	{
		if (null == viewCoursesDAO)
		{
			viewCoursesDAO = new ViewCoursesDAOMock();
		}

		return viewCoursesDAO;
	}

	@Override
	public IDeleteCourseDAO createDeleteCourseDAO()
	{
		if (null == deleteCourseDAO)
		{
			deleteCourseDAO = new DeleteCourseDAOMock();
		}

		return deleteCourseDAO;
	}

	@Override
	public IGrantInstructorAccessDAO createGrantInstructorAccessDAO()
	{
		if (null == grantInstructorAccessDAO)
		{
			grantInstructorAccessDAO = new GrantInstructorAccessDAOMock();
		}

		return grantInstructorAccessDAO;
	}

	@Override
	public IInstructorHandlerDAO createInstructorHandlerDAO()
	{
		if (null == instructorHandlerDAO)
		{
			instructorHandlerDAO = new InstructorHandlerDAOMock();
		}

		return instructorHandlerDAO;
	}

	@Override
	public IUserRoleHandlerDAO createUserRoleHandlerDAO()
	{
		if (null == userRoleHandlerDAO)
		{
			userRoleHandlerDAO = new UserRoleHandlerDAOMock();
		}

		return userRoleHandlerDAO;
	}
}