package com.main.app.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumerResponseError {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void sendResponse(String message){
		amqpTemplate.convertAndSend(
				"payment-response-error-exchange",
				"payment-response-error-route-key",
				message
		);
	}

}
