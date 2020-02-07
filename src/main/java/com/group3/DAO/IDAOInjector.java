package com.group3.DAO;

public interface IDAOInjector {
      IAddCourseDAO createAddCourseDAO();
      IViewCoursesDAO createViewCourseDAO();
      IDeleteCourseDAO createDeleteCourseDAO();
      IGrantInstructorAccessDAO createGrantInstructorAccessDAO();
      IInstructorHandlerDAO createInstructorHandlerDAO();
      IUserRoleHandlerDAO createUserRoleHandlerDAO();
}
