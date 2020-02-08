package com.group3.DAO;

public interface IDAOInjector {
	public IUserDAO createUserDAO();

	public LoginDao createLoginDAO();

	IAddCourseDAO createAddCourseDAO();

	IViewCoursesDAO createViewCourseDAO();

	IDeleteCourseDAO createDeleteCourseDAO();

	IGrantInstructorAccessDAO createGrantInstructorAccessDAO();

	IInstructorHandlerDAO createInstructorHandlerDAO();

	IUserRoleHandlerDAO createUserRoleHandlerDAO();

	public ICourseDAO createCourseDAO();

	public IStudentDAO createStudentDAO();

	public ITADAO createTADAO();

	public IInstructorDAO createInstructorDAO();
	
	public IUserPasswordDAO getUserDAOObj();

}
