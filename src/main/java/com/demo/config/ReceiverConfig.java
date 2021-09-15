package com.demo.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.demo.consumer.Listener;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ReceiverConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;




	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
		propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "50428800");
		propsMap.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "50428800");
		propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "20000");
		propsMap.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "30000");
		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group50");
		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		return propsMap;
	}

	@Bean
	public Listener listener() {
		return new Listener();
	}
	

}
