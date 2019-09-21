package com.dev.exceptions;

public class LoginException extends RuntimeException {
public String getMessage()
{
	return "login exception:Enter Correct username and password";
	
}
}
