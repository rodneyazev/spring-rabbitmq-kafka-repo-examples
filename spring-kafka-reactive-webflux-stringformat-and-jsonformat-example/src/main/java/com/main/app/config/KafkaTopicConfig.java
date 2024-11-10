package com.main.app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	NewTopic kafkaTopic(){
		return TopicBuilder
				.name("my_topic")
				//.partitions(5)
				//.replicas(0)
				.build();
	}
	
}
