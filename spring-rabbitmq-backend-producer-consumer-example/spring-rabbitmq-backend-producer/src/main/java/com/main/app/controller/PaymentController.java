package com.main.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.dto.PaymentDTO;
import com.main.app.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public String processPayment(@RequestBody PaymentDTO request) {
		return paymentService.requestPayment(request);
	}
}
