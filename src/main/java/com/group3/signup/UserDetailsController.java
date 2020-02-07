package com.group3.signup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.IUserDAO;
import com.group3.DAO.UserDAO;


@Controller
public class UserDetailsController {

	Connection conn;
	PreparedStatement statement;
	IUserDAO userDAO;
	GuestModel guestModel;
	IUserDetailsService userService;

	public UserDetailsController() {
		// TODO Auto-generated constructor stub
	
	}
	// Get User Details
	@RequestMapping("/signUp")
	public ModelAndView gotoSignUpPage() {
		return new ModelAndView(UserVerificationParameters.SIGN_UP);
	}

	@RequestMapping("/formSubmit")
	public ModelAndView getSignUpDetails(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("psw") String psw,
			@RequestParam("psw-repeat") String pswRpeat) throws SQLException, NullPointerException {

		ModelAndView mv = new ModelAndView();

		try {
			userDAO = new UserDAO();
			
			guestModel = new GuestModel(lastName, firstName, email, UserVerificationParameters.GUEST_USER, psw);
			userService = new UserDetailsService(userDAO);
			String output = userService.saveUser(lastName, firstName, email, psw, pswRpeat);
			if (output.contains(UserVerificationParameters.INVALID_PASSWORD_EMAIL)) {
				mv.addObject(UserVerificationParameters.MAIL_VALIDITY, UserVerificationParameters.VALID_EMAIL_MESSAGE);
				mv.addObject(UserVerificationParameters.STATUS, UserVerificationParameters.VALID_PASSWORD_MESSAGE);
				mv.setViewName(UserVerificationParameters.SIGN_UP);
			} else if (output.contains(UserVerificationParameters.INVALID_EMAIL)) {
				mv.addObject(UserVerificationParameters.MAIL_VALIDITY, UserVerificationParameters.VALID_EMAIL_MESSAGE);
				mv.setViewName(UserVerificationParameters.SIGN_UP);
			} else if (output.contains(UserVerificationParameters.INVALID_PASSWORD)) {
				mv.addObject(UserVerificationParameters.STATUS, UserVerificationParameters.VALID_PASSWORD_MESSAGE);
				mv.setViewName(UserVerificationParameters.SIGN_UP);
			} else if (output.contains(UserVerificationParameters.SIGNUP_SUCCESS)) {
				mv.addObject(UserVerificationParameters.SIGNUP_SUCCESS_MESSAGE, UserVerificationParameters.SIGNUP_PASSED);
				mv.setViewName(UserVerificationParameters.LOGIN);
			} else if (output.contains(UserVerificationParameters.USER_EXISTS)) {
				mv.addObject(UserVerificationParameters.USER, UserVerificationParameters.USER_EXISTS);
				mv.setViewName(UserVerificationParameters.LOGIN);
			} else {
				mv.setViewName(UserVerificationParameters.SIGN_UP);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView getLoginPage(ModelAndView mv) {
		return new ModelAndView(UserVerificationParameters.LOGIN);
	}
}
