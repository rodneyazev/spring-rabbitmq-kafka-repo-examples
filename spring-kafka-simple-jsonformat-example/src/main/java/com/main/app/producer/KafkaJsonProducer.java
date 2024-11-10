package com.main.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.main.app.payload.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {
	
	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;
	
	public void sendMessage(Student student) {
		Message<Student> message = MessageBuilder
				.withPayload(student)
				.setHeader(KafkaHeaders.TOPIC, "my_topic")
				.build();
		kafkaTemplate.send(message);
	}

}
