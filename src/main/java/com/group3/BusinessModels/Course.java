package com.group3.BusinessModels;

public class Course {
	 private String CourseID;
	    private String CourseName;

	    public Course() {
	    }

	    public String getCourseID() {
	        return this.CourseID;
	    }

	    public void setCourseID(String courseID) {
	        this.CourseID = courseID;
	    }

	    public String getCourseName() {
	        return this.CourseName;
	    }

	    public void setCourseName(String courseName) {
	        this.CourseName = courseName;
	    }
}
