package edu.uady.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerConfigUady {
	@Value("localhost:9092")
	private String hostServer;
	
	public Map<String,Object> producerConfig(){
		Map<String,Object> properties = new HashMap();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, hostServer);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return properties;
	}
	
	@Bean
	public ProducerFactory<String, String> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate (ProducerFactory<String, String> producerFactory){
		return new KafkaTemplate<>(producerFactory);
	}
}
