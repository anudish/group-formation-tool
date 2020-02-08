package com.group3.forgotPassword;

import org.springframework.web.servlet.ModelAndView;

public interface IUpdatePasswordManager {
	public ModelAndView compareCode(String code_input,String generated_code);
	public void updatePassword(String email,String password);
}
