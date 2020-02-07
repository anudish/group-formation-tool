package com.group3.DAO;

import com.group3.forgotPassword.IVerificationCode;

public class VerificationCodeMock implements IVerificationCode{

	@Override
	public String getNewCode(int n) {
		return "TCode";
	}
	
}
