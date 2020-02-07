package com.group3.course;

public class PasswordGenerator implements IPassword {

	public String getNewPassword(int n) 
	    { 
	        String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 
	  
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            int index = (int)(pattern.length() * Math.random()); 
	            sb.append(pattern.charAt(index)); 
	        } 
	        return sb.toString(); 
	    } 
}
