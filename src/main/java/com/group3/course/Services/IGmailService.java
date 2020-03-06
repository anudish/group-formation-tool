package com.group3.course.Services;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;

public interface IGmailService {
	public void setSMTPClient();

	public void prepareMail(String subject, String msg, String to);

	public void sendEmail();
}
