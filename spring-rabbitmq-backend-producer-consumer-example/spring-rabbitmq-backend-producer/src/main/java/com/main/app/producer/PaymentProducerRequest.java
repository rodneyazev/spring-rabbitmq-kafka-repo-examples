package com.main.app.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.app.dto.PaymentDTO;

@Component
public class PaymentProducerRequest {
	
	@Autowired
	private AmqpTemplate amqTemplate;
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public void paymentIntegrator(PaymentDTO payment) throws JsonProcessingException, AmqpException {
		amqTemplate.convertAndSend(
				"payment-request-exchange",
				"payment-request-route-key",
				objectMapper.writeValueAsString(payment)
		);		
	}
	
}
