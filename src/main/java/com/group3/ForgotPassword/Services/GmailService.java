package com.group3.ForgotPassword.Services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GmailService implements IGmailService {

	private static Logger logger = LogManager.getLogger(GmailService.class);
	Properties properties = null;
	Session session = null;
	Message msg = null;

	public void setSMTPClient() {

		properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("portalSoftwareDev@gmail.com", "Courseportal@07");
			}
		});
	}

	public void prepareMail(String subject, String message, String to) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

		try {
			msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("portalSoftwareDev@gmail.com", false));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject(subject);
			msg.setText(message);
		} catch (Exception e) {
			logger.info("Error occurred while preparing mail" + e);
		}
	}

	public void sendEmail() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
			Transport.send(msg);
		} catch (Exception e) {
			logger.info("Error in sending mail " + e);
		}
	}
}