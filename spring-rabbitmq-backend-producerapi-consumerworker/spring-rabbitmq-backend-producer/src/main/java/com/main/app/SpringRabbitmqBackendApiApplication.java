package com.main.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringRabbitmqBackendApiApplication {
	
	private static Logger log = LoggerFactory.getLogger(SpringRabbitmqBackendApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqBackendApiApplication.class, args);
		log.info("Payment Producer API started sucessfully.");
	}

}
