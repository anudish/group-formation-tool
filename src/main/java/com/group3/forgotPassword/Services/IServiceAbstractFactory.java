package com.group3.forgotPassword.Services;

import com.group3.forgotPassword.DAO.*;

public interface IServiceAbstractFactory {
	public IGmailService createGmailService(IEmailInjector emailInjector);
	public IResetCodeManager createResetCodeManager(IDAOInjector daoInjector, IEmailInjector emailInjector,
		IVerificationCode verificationCodeGenerator);
	public IUpdatePasswordManager createUpdatePasswordManager(IDAOInjector daoInjector);
	public IVerificationCode createVerificationCodeGenerator();
}