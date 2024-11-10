package com.main.app;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics="ecommerce.x", groupId="group")
	public void consumer(Product product) {
		System.out.println(product);
	}

}
