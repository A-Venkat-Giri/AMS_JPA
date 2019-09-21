package com.dev.exceptions;

public class DateFormatException extends RuntimeException {
	public String getMessage()
	{
		return "Enter the input in the correct format:YYYY-MM-DD";
		
	}
	}
