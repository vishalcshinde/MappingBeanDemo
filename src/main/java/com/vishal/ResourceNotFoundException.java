package com.vishal;



public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3919273534259043976L;
	
	
	ExceptionInfo info;
	public ResourceNotFoundException(ExceptionInfo info) {
		this.info = info;
	}
}
