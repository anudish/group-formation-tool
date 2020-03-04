package com.group3.forgotPassword.DAO;

import com.group3.forgotPassword.Services.IVerificationCode;

public class VerificationCodeMock implements IVerificationCode {

	@Override
	public String getNewCode(int n) {
		return "TCode";
	}

}