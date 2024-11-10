package com.rabbitmq.app;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqApplication.class, args);
	}

}