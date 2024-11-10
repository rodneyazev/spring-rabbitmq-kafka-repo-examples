package com.main.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringRabbitmqBackendWorkerApplication {
	
	private static Logger log = LoggerFactory.getLogger(SpringRabbitmqBackendWorkerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqBackendWorkerApplication.class, args);
		log.info("Payment Consumer API started sucessfully.");
	}

}
