package com.group3.DAO;

import com.group3.course.DAO.ICourseDAO;
import com.group3.course.DAO.IInstructorDAO;
import com.group3.course.DAO.IStudentDAO;
import com.group3.course.DAO.ITADAO;
import com.group3.forgotPassword.DAO.IUserPasswordDAO;
import com.group3.login.DAO.LoginDao;
import com.group3.signup.DAO.IUserDAO;

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
