package com.easy.easylog.domain.service.exception;

public class ServiceExcption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ServiceExcption(String message){
		super(message);
	}

	
}
