package com.group3.course.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class GmailServiceTest {

	public static GmailServiceMock gmailServiceMock;

	@BeforeAll
	public static void init() {
		gmailServiceMock = new GmailServiceMock();
	}

	@Test
	void setSMTPClientTest() {

		gmailServiceMock.setSMTPClient();
		assertThat(gmailServiceMock.properties).isNotEmpty();
		assertThat(gmailServiceMock.properties).isNotNull();
		assertThat(gmailServiceMock.session).isNotNull();
	}

	@Test
	void prepareMessageTest() {

		gmailServiceMock.prepareMail("Test Subject", "Test Message", "Test Recepient");
		assertThat(gmailServiceMock.msg).isNotNull();
	}

	@Test
	void propertiesTest() {
		
		gmailServiceMock.setSMTPClient();
		assertThat(gmailServiceMock.properties).isNotNull();
		assertThat(gmailServiceMock.properties).isNotEmpty();
	}

	@Test
	void sessionTest() {
		gmailServiceMock.setSMTPClient();
		assertThat(gmailServiceMock.session).isNotNull();
	}

	@Test
	void msgTest() {
		gmailServiceMock.prepareMail("Test Subject", "Test Message", "Test Recepient");
		assertThat(gmailServiceMock.msg).isNotNull();
	}
}