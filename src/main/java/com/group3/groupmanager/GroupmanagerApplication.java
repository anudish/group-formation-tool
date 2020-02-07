package com.group3.groupmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.group3.ApplicationContext.ConfigApplicationContext;
import com.group3.course.CourseController;
import com.group3.login.LoginController;
import com.group3.signup.UserDetailsController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackageClasses = {LoginController.class,CourseController.class, UserDetailsController.class})
public class GroupmanagerApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = 	SpringApplication.run(GroupmanagerApplication.class, args);
		new ConfigApplicationContext().setApplicationContext(context);
		
	}

}
