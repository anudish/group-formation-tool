package com.group3.DAO;

public class DAOInjector implements IDAOInjector {

	@Override
	public IAddCourseDAO createAddCourseDAO() {
		// TODO Auto-generated method stub
		return new AddCourseDAO();
	}

	@Override
	public IViewCoursesDAO createViewCourseDAO() {
		// TODO Auto-generated method stub
		return new ViewCoursesDAO();
	}

	@Override
	public IDeleteCourseDAO createDeleteCourseDAO() {
		// TODO Auto-generated method stub
		
		return new DeleteCourseDAO();
	}

	@Override
	public IGrantInstructorAccessDAO createGrantInstructorAccessDAO() {
		// TODO Auto-generated method stub
		return new GrantInstructorAccessDAO();
	}

	@Override
	public IInstructorHandlerDAO createInstructorHandlerDAO() {
		// TODO Auto-generated method stub
		return new InstructorHandlerDAO();
	}

	@Override
	public IUserRoleHandlerDAO createUserRoleHandlerDAO() {
		// TODO Auto-generated method stub
		return new UserRoleHandlerDAO();
	}
    
}
