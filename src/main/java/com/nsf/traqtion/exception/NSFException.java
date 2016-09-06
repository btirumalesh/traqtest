package com.nsf.traqtion.exception;

public class NSFException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6303285349346698799L;
	private NSFExceptionType NSFExceptionType;
	
	
	public NSFException(NSFExceptionType NSFExceptionType) {
		super(NSFExceptionType.getErrorMessage());
		this.NSFExceptionType = NSFExceptionType;
		
	}

	public NSFException(NSFExceptionType NSFExceptionType,Exception e) {
		super(NSFExceptionType.getErrorMessage(),e);
		this.NSFExceptionType = NSFExceptionType;
		
	}

	public NSFException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NSFException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NSFException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NSFException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NSFException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NSFExceptionType getNSFExceptionType() {
		return NSFExceptionType;
	}



	
	
}
