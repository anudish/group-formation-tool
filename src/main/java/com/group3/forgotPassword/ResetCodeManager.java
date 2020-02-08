package com.group3.forgotPassword;


import org.springframework.web.servlet.ModelAndView;

import com.group3.DAO.IUserPasswordDAO;
import com.group3.DAO.IDAOInjector;

public class ResetCodeManager implements IResetCodeManager{

	IGmailService gmailService;
	IUserPasswordDAO userDataAccess;
	IVerificationCode verificationCodeGenerator;
	private String generated_code;
	
	public ResetCodeManager(IDAOInjector userDAOFactory, IEmailInjector emailInjector, IVerificationCode verificationCodeGenerator)
	{
		gmailService = emailInjector.getGmailService();
		userDataAccess = userDAOFactory.getUserDAOObj();
		this.verificationCodeGenerator = verificationCodeGenerator;
	}
	
	public ModelAndView checkEmailIdExistance(String email)
	{
		//check if entry for this email is exist or not
		//if exist store EnterCode.htm in ModelAndView obj to send control there later on
		//if not exist then user have to enter email again, send control to EnterEmail.htm
		ModelAndView mv = new ModelAndView();
		
		if(userDataAccess.isUserExist(email) == false)
		{
			System.out.println("Email Id not exists...!!!");
			mv.addObject("status","We couldn't find account associated with this email id");
			mv.setViewName("EnterEmail.html");
		}
		else
		{
			System.out.println("Email Id exists...!!!");
//			sendCodeEmail(email);
			mv.addObject("status","");
			mv.setViewName("EnterCode.html");
		}
		
		return mv;
	}
	
	public void sendCodeEmail(String email)
	{
		
		//send the generated code on user provided email

		gmailService.setSMTPClient();
		gmailService.prepareMail("[University Portal] Please reset your password","You have requested a password reset for your account.\nBelow is the code that you have to use to enter new password \n\n\n"+generated_code+"\n\n\n If you don't wish to reset your password, disregard this email.",email);
		gmailService.sendEmail();
		System.out.println("Code sent on email...!!!");
	}
	
	public String generateCode(int length)
	{
		final int code_length = 5;
		//generate random code of length 5
		generated_code = verificationCodeGenerator.getNewCode(code_length);
		System.out.println(generated_code);
		return generated_code;
	}
}
