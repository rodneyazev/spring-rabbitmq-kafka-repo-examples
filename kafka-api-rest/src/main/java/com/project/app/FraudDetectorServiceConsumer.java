package com.project.app;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class FraudDetectorServiceConsumer {
	
	
	public static void main(String[] args) {
		
		var consumer = new KafkaConsumer<String, String>(properties());
			consumer.subscribe(Collections.singleton("ECOMMERCE_NEW_ORDER"));
			
			
		while(true) {
		
			var records = consumer.poll(Duration.ofMillis(100));
			
			if(!records.isEmpty()) {
				System.out.println("Encontrei " + records.count() + " registros.");
				for(var record: records) {
					System.out.println("===============================================");
					System.out.println("Processando nova ordem, checando por uma fraude");
					System.out.println(record.key());
					System.out.println(record.value());
					System.out.println(record.partition());
					System.out.println(record.offset());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Ordem processada com sucesso.");
				}
				continue;
			}			
		}
	}
	
	private static Properties properties() {
		var properties = new Properties();
		
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorServiceConsumer.class.getSimpleName());
		properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, FraudDetectorServiceConsumer.class.getSimpleName() + "-" + UUID.randomUUID().toString());
		properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
		
		
		return properties;
	}

}
