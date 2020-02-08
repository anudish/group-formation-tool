package com.group3.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group3.BusinessModels.LoginForm;
import com.group3.DAO.LoginDao;

@Controller
public class LoginController {
	
//		@PostMapping(path = "/login")
//	    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model){
//	        String email = loginForm.getEmail();
//	        String password = loginForm.getPassword();
//	       
//	        LoginDao ld = new LoginDao();
//	        System.out.println("in login controller");
//
//	
//	        model.addAttribute("invalidCredentials",true);
//	        return "login";       
//	    }


}
