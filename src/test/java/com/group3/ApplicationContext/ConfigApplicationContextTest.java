package com.group3.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;

class ConfigApplicationContextTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testGetApplicationContext() {
		ConfigurableApplicationContext ApplicationContext = new ConfigApplicationContext().getApplicationContext();
		assertEquals(ApplicationContext, new ConfigApplicationContext().getApplicationContext());
	}

	@Test
	final void testSetApplicationContext() {
		ConfigurableApplicationContext ApplicationContext = new  ConfigApplicationContext().getApplicationContext();
		new ConfigApplicationContext().setApplicationContext(ApplicationContext);
		assertEquals( ApplicationContext,new  ConfigApplicationContext().getApplicationContext());
	}

}
