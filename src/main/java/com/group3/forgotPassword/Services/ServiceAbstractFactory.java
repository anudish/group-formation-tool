package com.group3.forgotPassword.Services;

import com.group3.forgotPassword.DAO.*;

public class ServiceAbstractFactory implements IServiceAbstractFactory {

	public static IServiceAbstractFactory serviceInjector;
	public static IGmailService gmailService;
	public static IResetCodeManager resetCodeManager;
	public static IUpdatePasswordManager updatePasswordManager;
	public static IVerificationCode verificationCode;

	public static IServiceAbstractFactory instance() {
		if (null == serviceInjector) {
			serviceInjector = new ServiceAbstractFactory();
		}
		return serviceInjector;
	}

	@Override
	public IGmailService createGmailService(IEmailInjector emailInjector) {
		if (null == gmailService) {
			gmailService = new GmailService();
		}
		return gmailService;
	}

	@Override
	public IResetCodeManager createResetCodeManager(IDAOAbstractFactory daoInjector, IEmailInjector emailInjector, IVerificationCode verificationCodeGenerator) {
		if (null == resetCodeManager) {
			resetCodeManager = new ResetCodeManager(daoInjector, emailInjector, verificationCodeGenerator);
		}
		return resetCodeManager;
	}

	@Override
	public IUpdatePasswordManager createUpdatePasswordManager(IDAOAbstractFactory daoInjector) {
		if (null == updatePasswordManager) {
			updatePasswordManager = new UpdatePasswordManager(daoInjector);
		}
		return updatePasswordManager;
	}

	@Override
	public IVerificationCode createVerificationCodeGenerator() {
		if (null == verificationCode) {
			verificationCode = new VerificationCode();
		}
		return verificationCode;
	}
}