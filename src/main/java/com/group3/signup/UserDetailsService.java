package com.group3.signup;

import java.util.regex.Pattern;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.IUserDAO;

public class UserDetailsService implements IUserDetailsService {
	IUserDAO userDAO;
	GuestModel guestModel;

	public UserDetailsService(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String saveUser(String lastName, String firstName, String email, String psw, String pswRepeat)
			throws NullPointerException {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		String message = "";
		Pattern pat = Pattern.compile(emailRegex);

		guestModel = new GuestModel(lastName, firstName, email, "Guest", psw);

		Boolean emailValidate = pat.matcher(email).matches();

		if (!emailValidate || !psw.matches(pswRepeat)) {
			if (!emailValidate && !psw.matches(pswRepeat)) {
				message = UserVerificationParameters.INVALID_PASSWORD_EMAIL;
			} else if (!emailValidate) {
				message = UserVerificationParameters.INVALID_EMAIL;
			} else if (!psw.matches(pswRepeat)) {
				message = UserVerificationParameters.INVALID_PASSWORD;
			}
			return message;
		}

		else {
			Boolean checkInsert = false;
			checkInsert = userDAO.getSignUpDetailsofUser(guestModel);

			if (checkInsert) {
				message = UserVerificationParameters.SIGNUP_SUCCESS;
			} else {
				message = UserVerificationParameters.USER_EXISTS;
			}
			return message;
		}
	}

}
