package com.sms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sms.exception.SMSServiceException;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSMSService implements SMSService {
	
	@Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAuthToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

	@Override
	public void sendSMS(String phoneNumber, String message) throws SMSServiceException {
		// TODO Auto-generated method stub
		 try {
	            Twilio.init(twilioAccountSid, twilioAuthToken);
	            Message.creator(
	                    new PhoneNumber(phoneNumber),
	                    new PhoneNumber(twilioPhoneNumber),
	                    message)
	                    .create();
	        } catch (ApiException e) {
	        	e.printStackTrace();
	            throw new SMSServiceException("Failed to send SMS");
	        }
		
	}

}
