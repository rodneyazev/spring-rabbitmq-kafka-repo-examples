package com.main.app.consumer;

import java.util.Random;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.main.app.message.PaymentConsumerResponseError;
import com.main.app.message.PaymentConsumerResponseSuccess;

@Component
public class PaymentRequestConsumer {
	
	@Autowired
	private PaymentConsumerResponseError errorProducer;
	
	@Autowired
	private PaymentConsumerResponseSuccess successProducer;
	
	@RabbitListener(queues={"payment-request-queue"})
	public void receiveMessage(@Payload Message message) {
		System.out.println(message);
		if (new Random().nextBoolean()) {
			successProducer.sendResponse("Payment success " + message);
		} else {
			errorProducer.sendResponse("Payment failed " + message);
		}
	}
	
	
}
