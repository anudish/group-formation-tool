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

	@Override
	public ICourseDAO createCourseDAO() {
		// TODO Auto-generated method stub
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

	@Override
	public ITADAO createTADAO() {
	}
		return new TADAO();
	@Override
	public IInstructorDAO createInstructorDAO() {
	}
		return new InstructorDAO();