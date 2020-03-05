package com.group3.AdminAndAuthorization.DAO;

import com.group3.*;

public class DAOInjector implements IDAOInjector {

	static IAddCourseDAO addCourseDAO;
	static IViewCoursesDAO viewCoursesDAO;
	static IDeleteCourseDAO deleteCourseDAO;
	static IGrantInstructorAccessDAO grantInstructorAccessDAO;
	static IInstructorHandlerDAO instructorHandlerDAO;

	
	@Override
	public IAddCourseDAO createAddCourseDAO() {
		if(addCourseDAO == null) {
			addCourseDAO = new AddCourseDAO();
		}
		return addCourseDAO;
	}

	@Override
	public IViewCoursesDAO createViewCourseDAO() {
		if(viewCoursesDAO == null) {
			viewCoursesDAO = new ViewCoursesDAO();
		}
		return viewCoursesDAO;
	}

	@Override
	public IDeleteCourseDAO createDeleteCourseDAO() {
		if(deleteCourseDAO == null) {
			deleteCourseDAO = new DeleteCourseDAO();
		}
		return deleteCourseDAO;
	}

	@Override
	public IGrantInstructorAccessDAO createGrantInstructorAccessDAO() {
		if(grantInstructorAccessDAO == null) {
			grantInstructorAccessDAO = new GrantInstructorAccessDAO();;
		}
		return grantInstructorAccessDAO;
	}

	@Override
	public IInstructorHandlerDAO createInstructorHandlerDAO() {
		if(instructorHandlerDAO == null) {
			instructorHandlerDAO = new InstructorHandlerDAO(); 
		}
		return instructorHandlerDAO;
	}


}
	
		
	