package com.group3.DAO;

public class DAOMockInjector implements IDAOInjector {

	@Override
	public IAddCourseDAO createAddCourseDAO() {
		// TODO Auto-generated method stub
		return new AddCourseDAOMock();
	}

	@Override
	public IViewCoursesDAO createViewCourseDAO() {
		// TODO Auto-generated method stub
		return new ViewCoursesDAOMock();
	}

	@Override
	public IDeleteCourseDAO createDeleteCourseDAO() {
		// TODO Auto-generated method stub
		return new DeleteCourseDAOMock();
	}

	@Override
	public IGrantInstructorAccessDAO createGrantInstructorAccessDAO() {
		// TODO Auto-generated method stub
		return new GrantInstructorAccessDAOMock();
	}

	@Override
	public IInstructorHandlerDAO createInstructorHandlerDAO() {
		// TODO Auto-generated method stub
		return new InstructorHandlerDAOMock();
	}

	@Override
	public IUserRoleHandlerDAO createUserRoleHandlerDAO() {
		// TODO Auto-generated method stub
		return new UserRoleHandlerDAOMock();
	}

	@Override
	public ICourseDAO createCourseDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStudentDAO createStudentDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IUserDAO createUserDAO() {
		// TODO Auto-generated method stub
		return new UserDAOMock();
	}

	@Override
	public LoginDao createLoginDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}