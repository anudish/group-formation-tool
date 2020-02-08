package com.group3.DBConnectivity;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ObtainDataBaseConnectionTest {
    Connection dataBaseconnection;
	@BeforeEach
	void setUp() throws Exception {
		
		dataBaseconnection = ObtainDataBaseConnection.obtainDatabaseConnection();
	}

	@Test
	final void testObtainDatabaseConnection() {
		assertNotNull(dataBaseconnection);
	}

	@Test
	final void testTerminateConnection() {
		assertTrue(ObtainDataBaseConnection.terminateConnection());
	}

}
