package com.group3.groupmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GroupmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupmanagerApplication.class, args);
	}

}
