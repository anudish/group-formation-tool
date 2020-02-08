package com.group3.forgotPassword;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDAOInjector;

@Controller
public class forgetPasswordController {
	
	String generated_code;
	String email;
	
	IResetCodeManager resetCodeManager;
	IUpdatePasswordManager updatePasswordManager;
	IDAOInjector daoInjector;
	IVerificationCode verificationCodeGenerator;
	IEmailInjector emailInjector;
	
	
	public forgetPasswordController() {
		daoInjector = new DAOInjector();
		emailInjector = new EmailInjector();
		verificationCodeGenerator = new VerificationCode();
	}


	@RequestMapping("/enterEmail")
	public String enterEmail()
	{
		//call EnterEmail.html
		return "EnterEmail";
	}
	
	@RequestMapping("/enterCode")
	public ModelAndView enterCode(String email)
	{
		final int code_length = 8;
		this.email = email;

		ModelAndView mv;
		resetCodeManager = new ResetCodeManager(daoInjector,emailInjector, verificationCodeGenerator); 
		
		//check if user exist or not
		mv = resetCodeManager.checkEmailIdExistance(email);
		
		//generate random length code and email id to user
		generated_code = resetCodeManager.generateCode(code_length);
		resetCodeManager.sendCodeEmail(email);
		
		return mv;
	}
	
	@RequestMapping("/checkCode")
	public ModelAndView checkCode(String code_input)
	{
		ModelAndView mv;
		
		System.out.println("UserCode: "+code_input);
		System.out.println("GeneratedCode: "+generated_code);
		
		updatePasswordManager = new UpdatePasswordManager(daoInjector);
		
		//match the code enter by user with system generated code
		mv = updatePasswordManager.compareCode(code_input, generated_code);
		return mv;
	}
	
	@RequestMapping("/passwordUpdater")
	public String passwordUpdater(String password)
	{
		System.out.println("Password: "+password);
		System.out.println("email for Password to update: "+email);
		updatePasswordManager = new UpdatePasswordManager(daoInjector);
		updatePasswordManager.updatePassword(email, password);
		return "login";
	}
}
