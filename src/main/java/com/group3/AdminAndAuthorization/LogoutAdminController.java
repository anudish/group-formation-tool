package com.group3.AdminAndAuthorization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutAdminController {
	@RequestMapping("/logoutAdmin")
	String logoutRequest() {
	try {
		return "Login";
	} catch (NullPointerException e) {
		return "error.html";
	}
  }
}