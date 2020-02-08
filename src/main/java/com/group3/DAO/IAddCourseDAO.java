package com.group3.DAO;

import com.group3.BusinessModels.Course;

public interface IAddCourseDAO {
     String addCourse(Course course);
     String isCourseExist(String courseId);
     
}
