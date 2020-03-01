package com.group3.DAO;

public class DAOInjector implements IDAOInjector {

	static IAddCourseDAO addCourseDAO;
	static IViewCoursesDAO viewCoursesDAO;
	static IDeleteCourseDAO deleteCourseDAO;
	static IGrantInstructorAccessDAO grantInstructorAccessDAO;
	static IInstructorHandlerDAO instructorHandlerDAO;
	static IUserRoleHandlerDAO userRoleHandlerDAO;
	static ICourseDAO courseDAO;
	static IStudentDAO studentDAO;
	static IUserDAO userDAO;
	static ILoginDAO loginDAO;
	static ITADAO taDAO;
	static IInstructorDAO instructorDAO;
	static IUserPasswordDAO userPasswordDAO;
	
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

	@Override
	public IUserRoleHandlerDAO createUserRoleHandlerDAO() {
		if(userRoleHandlerDAO == null) {
			userRoleHandlerDAO = new UserRoleHandlerDAO();
		}
		return userRoleHandlerDAO;
	}

	@Override
	public ICourseDAO createCourseDAO() {
		if(courseDAO == null) {
			courseDAO = new CourseDAO();
		}
		return courseDAO;
	}

	@Override
	public IStudentDAO createStudentDAO() {
		if(studentDAO == null) {
			studentDAO = new StudentDAO();
		}
		return studentDAO;
	}

	@Override
	public IUserDAO createUserDAO() {
		if(userDAO == null) {
			userDAO = new UserDAO();
		}
		return userDAO;
	}

	@Override
	public LoginDao createLoginDAO() {
		if(loginDAO == null) {
			loginDAO = new LoginDao();
		}
		return new LoginDao();
	}
    
	@Override
	public ITADAO createTADAO() {
		if(taDAO == null) {
			taDAO = new TADAO();
		}
		return taDAO;
	}
	@Override
	public IInstructorDAO createInstructorDAO() {
		if(instructorDAO == null) {
			instructorDAO = new InstructorDAO();
		}
		return instructorDAO;
	}
	
	public IUserPasswordDAO getUserDAOObj(){
		if(userPasswordDAO == null) {
			userPasswordDAO = new UserPasswordDAO();
		}
		return userPasswordDAO;
	}
}
	
		
	