package com.group3.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    public static Logger logger = LogManager.getLogger(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception ex)
    {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.error("Request "+ request.getRequestURL()+ "Threw an Exception", ex);
        return "error";
    }
}
