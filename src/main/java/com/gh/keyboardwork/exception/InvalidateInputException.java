package com.gh.keyboardwork.exception;

public class InvalidateInputException extends Exception {
	static final long serialVersionUID = -3387516993124229948L;
	
	public InvalidateInputException(){
		super();
	}
	
	public InvalidateInputException(String messagge){
		super(messagge);
	}

}
