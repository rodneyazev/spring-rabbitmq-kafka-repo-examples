package com.main.app.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics="my_topic", groupId="mygroup")
	public void consumeMsg(String msg) {
		log.info(String.format("Consuming the message from my topic :: %s", msg ));
	}
}
