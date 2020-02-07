package com.group3.forgotPassword;

public class EmailInjector implements IEmailInjector {
	//@Override
	public GmailService getGmailService() {
		return new GmailService();
	}
}
