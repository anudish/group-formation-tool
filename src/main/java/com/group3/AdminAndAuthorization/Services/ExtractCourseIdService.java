package com.group3.AdminAndAuthorization.Services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class ExtractCourseIdService implements IExtractCourseIdService {
	String courseId;
	private static Logger logger = LogManager.getLogger(ExtractCourseIdService.class);

	public ExtractCourseIdService(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String extractCourseId() {
		int index = this.courseId.lastIndexOf('-');
		this.courseId = this.courseId.substring(0, index);
		return this.courseId;
	}
}