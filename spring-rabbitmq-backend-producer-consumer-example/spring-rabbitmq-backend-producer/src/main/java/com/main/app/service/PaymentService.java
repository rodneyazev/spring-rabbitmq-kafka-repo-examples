package com.main.app.service;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.main.app.dto.PaymentDTO;
import com.main.app.producer.PaymentProducerRequest;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentProducerRequest producer;

	public String requestPayment(PaymentDTO request) {
		try {
			producer.paymentIntegrator(request);
		} catch (JsonProcessingException | AmqpException e) {
			return "Error to request payment ..." + e.getMessage();
		}
		return "Waiting payment confirmation ...";
	}
}
