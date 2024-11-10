package com.rabbitmq.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {
	
	@Autowired
    private Producer producer;
	
	@GetMapping("/test")
    public String send(){
        producer.send("test message");
        return "Message sent successfully.";
    }

}
