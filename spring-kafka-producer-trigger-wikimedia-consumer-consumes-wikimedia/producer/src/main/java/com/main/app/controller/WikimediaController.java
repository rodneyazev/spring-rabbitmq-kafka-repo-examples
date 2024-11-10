package com.main.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.stream.WikimediaStreamConsumer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/wikimedia")
public class WikimediaController {
	
	@Autowired
	WikimediaStreamConsumer streamConsumer;
	
	@GetMapping
	public void startPublishing() {
		streamConsumer.consumeStreamAndPublish();
	}

}
