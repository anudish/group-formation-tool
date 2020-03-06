package com.group3.ForgotPassword.Services;

import org.springframework.web.servlet.ModelAndView;

import com.group3.ForgotPassword.DAO.*;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UpdatePasswordManager implements IUpdatePasswordManager {

    private static Logger logger = LogManager.getLogger(UpdatePasswordManager.class);
    IUserPasswordDAO userDataAccess;

    public UpdatePasswordManager(IDAOAbstractFactory DAOInjector) {

        userDataAccess = DAOInjector.getUserDAOObj();
    }

    public ModelAndView compareCode(String code_input, String generated_code) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.info("Comparing entered code with generated code!");
        ModelAndView mv = new ModelAndView();
        if (code_input.equals(generated_code)) {
            logger.debug("Usercode matches!");
            mv.addObject("invalidcode", "no");
            mv.setViewName("NewPassword.html");
        } else {
            logger.debug("Invalid Usercode. Code does not matches!");
            mv.addObject("invalidcode", "Inavlid Code! Try again!");
            mv.setViewName("EnterCode.html");
        }
        return mv;
    }

    public void updatePassword(String email, String password) {
        userDataAccess.updateNewPassword(email, password);
    }
}