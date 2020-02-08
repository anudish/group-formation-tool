package com.group3.forgotPassword;

import org.springframework.web.servlet.ModelAndView;

import com.group3.DAO.IUserPasswordDAO;
import com.group3.DAO.IDAOInjector;

public class UpdatePasswordManager implements IUpdatePasswordManager{
	IUserPasswordDAO userDataAccess;
	
	public UpdatePasswordManager(IDAOInjector DAOInjector) {
		userDataAccess = DAOInjector.getUserDAOObj();
	}
	
	
	public ModelAndView compareCode(String code_input,String generated_code)
	{
		//check if code entered by user matches with system generated code
		//if matches store NewPassword.htm in ModelAndView obj to send control there later on
		//if not match then user have to enter code again, send control to EnterCode.htm
		ModelAndView mv = new ModelAndView();
		if(code_input.equals(generated_code))
		{
			mv.addObject("invalidcode","no");
			mv.setViewName("NewPassword.html");
		}
		else
		{
			mv.addObject("invalidcode","Inavlid Code...!!! Try again...!!!");
			mv.setViewName("EnterCode.html");
		}
		return mv;
	}
	
	public void updatePassword(String email,String password)
	{
		//update new password
		userDataAccess.updateNewPassword(email, password);
	}
}
