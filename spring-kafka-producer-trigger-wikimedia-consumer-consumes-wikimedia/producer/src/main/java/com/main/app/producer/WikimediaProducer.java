package com.main.app.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
		log.info(String.format("Sending message to topic::%s ", msg));
		kafkaTemplate.send("wikimedia_topic", msg);
	}

}
