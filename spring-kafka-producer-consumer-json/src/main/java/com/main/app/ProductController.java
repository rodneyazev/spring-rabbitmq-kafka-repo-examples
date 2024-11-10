package com.main.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class ProductController {
	
	@Autowired
	private KafkaTemplate<String, Product> kakfaTemplate;
	
	@GetMapping("/product/{message}/{name}")
	public void product(@PathVariable String message, @PathVariable String name) {
		Product product = new Product(message, name);
		this.kakfaTemplate.send("ecommerce.x", product);
	}

}
