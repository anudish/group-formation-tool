package com.group3.groupmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.group3.DBConnectivity.ConnectionParameters;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.CourseController;
import com.group3.course.StudentCSVController;
import com.group3.course.TAController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackageClasses = {CourseController.class,ConnectionParameters.class,ObtainDataBaseConnection.class,TAController.class,StudentCSVController.class})
public class GroupmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupmanagerApplication.class, args);
	}

}
