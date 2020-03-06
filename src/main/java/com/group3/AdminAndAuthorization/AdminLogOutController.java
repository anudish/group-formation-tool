package com.group3.AdminAndAuthorization;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLogOutController {

	private static Logger logger = LogManager.getLogger(AdminLogOutController.class);

	@RequestMapping("/adminLogout")
	String adminLogout() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
			return "Login.html";

		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return "error.html";
		}
	}
}