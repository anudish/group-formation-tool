package com.group3.groupmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.group3.ApplicationContext.ConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GroupmanagerApplication {
//hello comment
	public static void main(String[] args) {
	ConfigurableApplicationContext context = 	SpringApplication.run(GroupmanagerApplication.class, args);
		new ConfigApplicationContext().setApplicationContext(context);
		
	}

}
