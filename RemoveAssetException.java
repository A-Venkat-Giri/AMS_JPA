package com.dev.exceptions;

public class RemoveAssetException extends RuntimeException {
public String getMessage()
{
	return "Remove asset exception:The Asset Id You Entered Is Not Avaliable In The Assets";
	
}
}
