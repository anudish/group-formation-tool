package com.group3.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group3.BusinessModels.LoginForm;
import com.group3.DAO.LoginDao;

@Controller
public class LoginController {
	
//	@RequestMapping("/login")
//    public String showLoginPage(){
//        return "login";
//    }
	
//	@RequestMapping("/signUp")
//    public String showSignUpPage(){
//        return "signUp";
//    }
	
	// checking for login credentials
//	@PostMapping(path = "/login")
//    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model){
//        String email = loginForm.getEmail();
//        String password = loginForm.getPassword();
//       
//        LoginDao ld = new LoginDao();
//        System.out.println("in login controller");
//		int n = ld.getUserByEmail(email, password);
//		System.out.println("no of rows: "+ n);
//
//		if(n>0) {
//			return "home";
//		}
//
//        
//        model.addAttribute("invalidCredentials",true);
//        return "login";       
//    }
}