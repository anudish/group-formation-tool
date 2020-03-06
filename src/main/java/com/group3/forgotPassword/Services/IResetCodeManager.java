package com.group3.forgotPassword.Services;

import org.springframework.web.servlet.ModelAndView;

public interface IResetCodeManager {
	public void sendCodeEmail(String email);

	public String generateCode(int length);

	public ModelAndView checkEmailIdExistance(String email);
}
