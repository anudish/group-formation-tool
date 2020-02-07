package com.group3.course;

public class EmailInjector implements IEmailInjector {
	@Override
	public IGmailService getGmailService() {
		return new GmailService();
	}
}
