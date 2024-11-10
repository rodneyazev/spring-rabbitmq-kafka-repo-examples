package com.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	public static final String topics = "mytopic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void publishTopic(String message) {
		System.out.println("Publishing to topic: " + topics);
		this.kafkaTemplate.send(topics, message);
	}
	
}
