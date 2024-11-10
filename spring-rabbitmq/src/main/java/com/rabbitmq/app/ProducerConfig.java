package com.rabbitmq.app;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
	
	@Value("test")
    private String msg;

    @Bean
    Queue queue() {
        return new Queue(msg, true);
    }
}
