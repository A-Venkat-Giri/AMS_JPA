package com.dev.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dev.exceptions.DateFormatException;
import com.dev.exceptions.IntegerValidationException;
import com.dev.exceptions.StringValidationException;


public class Validate {

	IntegerValidationException ie=new IntegerValidationException();
	StringValidationException se=new StringValidationException();
	DateFormatException de=new DateFormatException();
	public String integerValidation(String id) {
		Pattern pat = Pattern.compile("\\d+"); 
		Matcher mat = pat.matcher(id);
		if(mat.matches() && (Integer.parseInt(id)>=0))
		{

			return id;
		}

		else
		{
			throw ie;
		}

	}
	public String stringValidation(String name)  {
		Pattern pat = Pattern.compile("[A-Za-z]{1,25}"); 
		Matcher mat = pat.matcher(name);
		if(mat.matches()) 
		{
			return name;
		}
		else
		{
			throw se;
		}
	}
	public String checkDate(String date) {
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher = pattern.matcher(date);
		if(matcher.matches())
		{
			return date;
		}
		else
		{
			throw de;
		}
	}
}





