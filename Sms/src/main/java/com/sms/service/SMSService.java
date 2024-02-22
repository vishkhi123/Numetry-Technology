package com.sms.service;

import com.sms.exception.SMSServiceException;

public interface SMSService {
	void sendSMS(String phoneNumber, String message) throws SMSServiceException;

}
