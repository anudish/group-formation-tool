package com.group3.course.Services;

import com.group3.course.DAO.*;

public class ServiceAbstractFactory implements IServiceAbstractFactory {

	public static IServiceAbstractFactory serviceInjector;
	public static ICourseManager courseManager;
	public static IStudentManager studentManager;
	public static ITAManager taManager;
	public static IGmailService gmailService;
	public static IPassword passwordGenerator;

	public static IServiceAbstractFactory instance() {
		if (null == serviceInjector) {
			serviceInjector = new ServiceAbstractFactory();
		}
		return serviceInjector;
	}

	@Override
	public ICourseManager createCourseManager(IDAOAbstractFactory daoInjector) {
		if (null == courseManager) {
			courseManager = new CourseManager(daoInjector);
		}
		return courseManager;
	}

	@Override
	public IStudentManager createStudentManager(IDAOAbstractFactory daoInjector, IEmailInjector emailInjector, IPassword password) {
		if (null == studentManager) {
			studentManager = new StudentManager(daoInjector, emailInjector, password);
		}
		return studentManager;
	}

	@Override
	public ITAManager createTAManager(IDAOAbstractFactory daoInjector) {
		if (null == taManager) {
			taManager = new TAManager(daoInjector);
		}
		return taManager;
	}

	@Override
	public IGmailService createGmailService() {
		if (null == gmailService) {
			gmailService = new GmailService();
		}
		return gmailService;
	}

	@Override
	public IPassword createPasswordGenerator() {
		if (null == passwordGenerator) {
			passwordGenerator = new PasswordGenerator();
		}
		return passwordGenerator;
	}
}