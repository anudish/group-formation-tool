package com.group3.forgotPassword;

public interface IGmailService {
	
	public void setSMTPClient();
	public void prepareMail(String subject, String msg, String to);
	public void sendEmail();

}
