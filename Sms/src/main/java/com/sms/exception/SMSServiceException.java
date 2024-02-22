package com.sms.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SMSServiceException extends RuntimeException {
	
	public SMSServiceException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

}
