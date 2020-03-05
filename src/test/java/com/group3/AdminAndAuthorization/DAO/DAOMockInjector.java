package com.group3.AdminAndAuthorization.DAO;

import com.group3.AdminAndAuthorization.DAO.IDAOInjector;
import com.group3.AdminAndAuthorization.DAO.*;

public class DAOMockInjector implements IDAOInjector {

	@Override
	public IAddCourseDAO createAddCourseDAO() {

		return new AddCourseDAOMock();
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





	
}
