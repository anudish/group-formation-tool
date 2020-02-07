package com.group3.Services;

import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.IAddCourseDAO;
import com.group3.DAO.IDeleteCourseDAO;
import com.group3.DAO.IGrantInstructorAccessDAO;
import com.group3.DAO.IInstructorHandlerDAO;
import com.group3.DAO.IUserRoleHandlerDAO;
import com.group3.DAO.IViewCoursesDAO;

public interface IServiceInjector {
	 ICourseInputValidation createCourseInputValidation();
	 IAddCourseService      createaddCourseService(IAddCourseDAO iAddCourseDAO);
	 IViewCoursesService    createViewCoursesService(IViewCoursesDAO iViewCoursesDAO);
	 IDeleteCourseService   createDeleteCourseService(IDeleteCourseDAO iDeleteCourseDAO, Course course);
     IGrantInstructorAccessService createGrantInstructorAccessService(IGrantInstructorAccessDAO iGrantInstructorAccessDAO);
     IAdminPageServices     createAdminPageServices(IInstructorHandlerDAO iInstructorHandlerDAO, IUserRoleHandlerDAO iUserRoleHandlerDAO, GuestModel guestmodel, String CourseId);
     IExtractCourseIdService createExtractCourseIdService(String InputCourseString);
     IGrantAccessFieldsValidation createGrantAccessFieldsValidation(String courseName, String role);
}
