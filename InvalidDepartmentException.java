package com.dev.exceptions;

public class InvalidDepartmentException extends RuntimeException {
	public String getMessage()
	{
		return "Invalid Department ID";
		
	}
	}