package com.example.webservices.user.exception;

import java.util.Date;

public class ExceptionResource {
	
	private String message;
	private Date date;
	private String Details;
	public ExceptionResource(String message, Date date, String details) {
		super();
		this.message = message;
		this.date = date;
		Details = details;
	}
	public String getMessage() {
		return message;
	}
	public Date getDate() {
		return date;
	}
	public String getDetails() {
		return Details;
	}

}
