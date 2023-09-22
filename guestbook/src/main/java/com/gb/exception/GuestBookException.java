package com.gb.exception;

public class GuestBookException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public GuestBookException() {
		super("GuestBookDAOException Occurs");
	}
	
	public GuestBookException(String msg) {
		super(msg);
	}
}
