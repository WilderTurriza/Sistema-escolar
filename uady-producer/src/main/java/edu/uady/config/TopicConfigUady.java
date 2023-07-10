package edu.uady.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfigUady {

	@Bean
	public NewTopic topicCreate() {
		Map<String,String> configurations = new HashMap<>();
		configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
		configurations.put(TopicConfig.RETENTION_MS_CONFIG, "1000");
		configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1000");
		configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "50");
		
		return TopicBuilder.name("uady-topic")
				.partitions(2)
				.replicas(2)
				.configs(configurations)
				.build();
		
	}
}
