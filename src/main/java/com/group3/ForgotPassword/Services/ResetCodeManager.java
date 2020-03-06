package com.group3.ForgotPassword.Services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.servlet.ModelAndView;

import com.group3.ForgotPassword.DAO.*;
import com.group3.ForgotPassword.DAO.IUserPasswordDAO;

public class ResetCodeManager implements IResetCodeManager {

    private static Logger logger = LogManager.getLogger(ResetCodeManager.class);
    IGmailService gmailService;
    IUserPasswordDAO userDataAccess;
    IVerificationCode verificationCodeGenerator;
    private String generated_code;

    public ResetCodeManager(IDAOAbstractFactory userDAOFactory, IEmailInjector emailInjector,
                            IVerificationCode verificationCodeGenerator) {

        gmailService = emailInjector.getGmailService();
        userDataAccess = userDAOFactory.getUserDAOObj();
        this.verificationCodeGenerator = verificationCodeGenerator;
    }

    public ModelAndView checkEmailIdExistance(String email) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        ModelAndView mv = new ModelAndView();
        if (userDataAccess.isUserExist(email) == false) {
            logger.debug("User " + email + " not exists!");
            mv.addObject("status", "We couldn't find account associated with this email id");
            mv.setViewName("EnterEmail.html");
            logger.info("Letting user enter email id again.");
        } else {
            logger.debug("User " + email + " exists!");
            mv.addObject("status", "successfull");
            mv.setViewName("EnterCode.html");
        }
        return mv;
    }

    public void sendCodeEmail(String email) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        gmailService.setSMTPClient();
        gmailService.prepareMail("[University Portal] Please reset your password",
                "You have requested a password reset for your account.\nBelow is the code that you have to use to enter new password \n\n\n"
                        + generated_code + "\n\n\n If you don't wish to reset your password, disregard this email.",
                email);
        gmailService.sendEmail();
        logger.info("Code sent via email!");
    }

    public String generateCode(int length) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        if (length > 0) {
            generated_code = verificationCodeGenerator.getNewCode(length);
        } else {
            throw new IllegalArgumentException("Code length: " + length + " must not be negative or zero!");
        }
        logger.info("Code Generated!");
        logger.debug("Generated Code: " + generated_code);
        return generated_code;
    }
}