package com.group3.signup;

public interface IUserDetailsService {
	public String saveUser(String lastName, String firstName, String email, String psw, String pswRepeat);
}
