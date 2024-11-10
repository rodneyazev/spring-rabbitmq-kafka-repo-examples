package com.main.app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaWikimediaTopicConfig {
	
	@Bean
	NewTopic kafkaWikimediaTopic(){
		return TopicBuilder
				.name("wikimedia_topic")
				//.partitions(5)
				//.replicas(0)
				.build();
	}
	
}
