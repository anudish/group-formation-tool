package com.group3.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group3.BusinessModels.LoginForm;

@Controller
public class LoginController {

		@PostMapping(path = "/login")
	    public String login(){
	       
	        return "login";
	    }

}
