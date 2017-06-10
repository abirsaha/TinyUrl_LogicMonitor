package com.lm.exception;

public class UrlException extends Exception{

	private static final long serialVersionUID = -5401342744194121293L;
	private String message = null;

	public UrlException(String s){  
		  super(s);
		  this.message = s;
	}
	
	@Override
    public String getMessage() {
        return message;
    }
	
}
