package com.group3.AdminAndAuthorization.Services;

import com.group3.AdminAndAuthorization.DAO.*;
import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.GuestModel;
import com.group3.Services.*;

public interface IServiceInjector {
	 ICourseInputValidation createCourseInputValidation();
	 IAddCourseService createaddCourseService(IAddCourseDAO iAddCourseDAO);
	 IViewCoursesService    createViewCoursesService(IViewCoursesDAO iViewCoursesDAO);
	 IDeleteCourseService   createDeleteCourseService(IDeleteCourseDAO iDeleteCourseDAO, Course course);
     IGrantInstructorAccessService createGrantInstructorAccessService(IGrantInstructorAccessDAO iGrantInstructorAccessDAO);
     IAdminPageServices     createAdminPageServices(IInstructorHandlerDAO iInstructorHandlerDAO, IUserRoleHandlerDAO iUserRoleHandlerDAO, GuestModel guestmodel, String CourseId);
     IExtractCourseIdService createExtractCourseIdService(String InputCourseString);
     IGrantAccessFieldsValidation createGrantAccessFieldsValidation(String courseName, String role);
}
