package com.rabbitmq.app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@RabbitListener(queues = {"${queue.name}"})
	public void receiver(@Payload String msg) {
		System.out.println("Message: " + msg);
	}
	
}
