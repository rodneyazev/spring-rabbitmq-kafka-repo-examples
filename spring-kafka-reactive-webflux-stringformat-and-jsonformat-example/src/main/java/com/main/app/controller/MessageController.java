package com.main.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.payload.Student;
import com.main.app.producer.KafkaJsonProducer;
import com.main.app.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
	
	@Autowired
	KafkaProducer kafkaProducer;
	
	@Autowired
	KafkaJsonProducer kafkaJsonProducer;
	
	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message queued successfully.");
	}
	
	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessage(@RequestBody Student message){
		kafkaJsonProducer.sendMessage(message);
		return ResponseEntity.ok("Message JSON queued successfully.");
	}
	
}
