package com.group3.AdminAndAuthorization.Services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class GrantAccessFieldsValidation implements IGrantAccessFieldsValidation {
	private String courseName, role;
	private static Logger logger = LogManager.getLogger(GrantAccessFieldsValidation.class);
	public GrantAccessFieldsValidation(String courseName, String role) {
		this.courseName = courseName;
		this.role = role;

	}

	@Override
	public String validateFields() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		String feedBackMessage = new String();
		try {
		if (courseName.equals("Select courses")) {
			feedBackMessage = "Select Course " + "\n";
		}
		if (role.equals("Select Role")) {
			feedBackMessage += "Select Role" + "\n";
			}
		} catch (StringIndexOutOfBoundsException str) {
			logger.error(str.getMessage());
		}
		catch(NullPointerException np) {
			logger.error(np.getMessage());
		}
		return feedBackMessage;
	}
}