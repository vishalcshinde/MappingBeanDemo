package com.vishal;

public class ExceptionInfo {
	int code;
	String message;

	public ExceptionInfo(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ExceptionInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
