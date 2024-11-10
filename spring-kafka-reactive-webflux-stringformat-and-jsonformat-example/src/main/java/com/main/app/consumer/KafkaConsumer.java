package com.main.app.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.main.app.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics="my_topic", groupId="mygroup")
	public void consumeJsonMsg(Student student) {
		log.info(String.format("Consuming the message from my topic :: %s", student.toString() ));
	}
}
