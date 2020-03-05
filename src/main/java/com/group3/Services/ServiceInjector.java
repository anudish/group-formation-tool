package com.group3.Services;
import com.group3.AdminAndAuthorization.DAO.*;
import com.group3.AdminAndAuthorization.Services.*;
import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.GuestModel;

public class ServiceInjector implements IServiceInjector{

	@Override
	public ICourseInputValidation createCourseInputValidation() {
		
		return new CourseInputValidation();
	}

	@Override
	public IAddCourseService createaddCourseService(IAddCourseDAO iAddCourseDAO) {
		
		return new AddCourseService(iAddCourseDAO);
	}

	@Override
	public IViewCoursesService createViewCoursesService(IViewCoursesDAO iViewCoursesDAO) {
		
		return new ViewCoursesService(iViewCoursesDAO);
	}

	@Override
	public IDeleteCourseService createDeleteCourseService(IDeleteCourseDAO iDeleteCourseDAO,Course course) {
		
		return new DeleteCourseService(iDeleteCourseDAO,course);
	}

	@Override
	public IGrantInstructorAccessService createGrantInstructorAccessService(
			IGrantInstructorAccessDAO iGrantInstructorAccessDAO) {
		
		return new GrantInstructorAccessService(iGrantInstructorAccessDAO);
	}

	@Override
	public IAdminPageServices createAdminPageServices(IInstructorHandlerDAO iInstructorHandlerDAO,
			IUserRoleHandlerDAO iUserRoleHandlerDAO,GuestModel guestmodel,String CourseId) {
		
		return new AdminPageServices(iInstructorHandlerDAO,iUserRoleHandlerDAO, guestmodel, CourseId ) ;
	}

	@Override
	public IExtractCourseIdService createExtractCourseIdService(String InputCourseString) {
		
		return new ExtractCourseIdService(InputCourseString);
	}

	@Override
	public IGrantAccessFieldsValidation createGrantAccessFieldsValidation(String courseName, String role) {
		
		return new GrantAccessFieldsValidation( courseName,  role);
	}

	
	

	

}
