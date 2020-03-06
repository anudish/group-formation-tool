package com.group3.AdminAndAuthorization;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminDashBoardMainPageController {
	private static Logger logger = LogManager.getLogger(AdminDashBoardMainPageController.class);

	@RequestMapping("/adminMainPageRequest")
	public String returnAdminDashBoardPage() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
			return "AdminMainPage.html";

		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return "error.html";
		}

	}
}