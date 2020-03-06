package com.group3.ForgotPassword;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group3.ForgotPassword.DAO.*;
import com.group3.ForgotPassword.Services.*;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Controller
public class ForgetPasswordController {
	private static Logger logger = LogManager.getLogger(ForgetPasswordController.class);
	String generated_code;
	String email;

	IDAOAbstractFactory daoInjector;
	IEmailInjector emailInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	IVerificationCode verificationCodeGenerator;
	IResetCodeManager resetCodeManager;
	IUpdatePasswordManager updatePasswordManager;

	public ForgetPasswordController() {

		daoInjector = DAOAbstractFactory.instance();
		emailInjector = EmailInjector.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		verificationCodeGenerator = serviceAbstractFactory.createVerificationCodeGenerator();
		resetCodeManager = serviceAbstractFactory.createResetCodeManager(daoInjector, emailInjector,
				verificationCodeGenerator);
		updatePasswordManager = serviceAbstractFactory.createUpdatePasswordManager(daoInjector);
	}

	@RequestMapping("/enterEmail")
	public String enterEmail() {
		return "EnterEmail";
	}

	@RequestMapping("/enterCode")
	public ModelAndView enterCode(String email) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		final int code_length = 5;
		this.email = email;
		ModelAndView mv;
		mv = resetCodeManager.checkEmailIdExistance(email);

		try {
			generated_code = resetCodeManager.generateCode(code_length);
		} catch (IllegalArgumentException e) {
			logger.error("Error passing length to verification code generator! " + e);
		}

		resetCodeManager.sendCodeEmail(email);
		return mv;
	}

	@RequestMapping("/checkCode")
	public ModelAndView checkCode(String code_input) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		ModelAndView mv;
		logger.debug("UserCode: " + code_input);
		logger.debug("GeneratedCode: " + generated_code);
		mv = updatePasswordManager.compareCode(code_input, generated_code);
		return mv;
	}

	@RequestMapping("/passwordUpdater")
	public String passwordUpdater(String password) {
		updatePasswordManager.updatePassword(email, password);
		return "login";
	}
}
