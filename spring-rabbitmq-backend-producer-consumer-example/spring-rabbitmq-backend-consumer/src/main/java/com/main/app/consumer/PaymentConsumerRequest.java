package com.main.app.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumerRequest {
	
	@RabbitListener(queues={"payment-request-queue"})
	public void receiveMessage(@Payload Message message) {
		System.out.println(message);
	}
}
