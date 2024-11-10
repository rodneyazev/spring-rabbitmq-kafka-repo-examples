package com.project.app;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.serialization.StringSerializer;

public class NewOrderMainProducer {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		var producer = new KafkaProducer<String, String>(properties());
		var key = Uuid.randomUuid().toString();
		var value = "3123213, 12344, 4323531";
		var record = new ProducerRecord<String, String>("ECOMMERCE_NEW_ORDER", key, value);
		
		Callback callback = (data, ex) -> {
			if(ex != null ) {
				ex.printStackTrace();
				return ;
			}
			System.out.println("Sucesso enviando: " + data.topic() + ":::partition" + data.partition() + "/ offset " + data.offset() + "/ timestamp " + data.timestamp());
		};
		
		var email = "Thank you for your Order. Please, stand by, while we process it!";
		var emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL", key, email);
		producer.send(record, callback).get();
		producer.send(emailRecord).get();
		
	}
	
	private static Properties properties() {
		
		var properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return properties;
		
	}

}
