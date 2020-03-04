package com.group3.forgotPassword.Services;

import com.group3.forgotPassword.DAO.*;

public interface IServiceAbstractFactory {
	public IGmailService createGmailService(IEmailInjector emailInjector);
	public IResetCodeManager createResetCodeManager(IDAOAbstractFactory daoInjector, IEmailInjector emailInjector,
		IVerificationCode verificationCodeGenerator);
	public IUpdatePasswordManager createUpdatePasswordManager(IDAOAbstractFactory daoInjector);
	public IVerificationCode createVerificationCodeGenerator();
}