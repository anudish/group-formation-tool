package com.group3.AdminAndAuthorization.Services;

public class ExtractCourseIdService implements IExtractCourseIdService {
    String CourseId;
    public ExtractCourseIdService(String CourseId) {
    	
    	this.CourseId = CourseId;
    }
	@Override
	public String extractCourseId() {
		// TODO Auto-generated method stub
		int index = this.CourseId.lastIndexOf('-');
		this.CourseId = this.CourseId.substring(0, index);
		return this.CourseId;
	}

}
