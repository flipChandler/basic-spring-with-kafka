package com.br.felipe.strproducer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringProducerService {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${app-config.topic.str-topic}")
	private String strTopic;
	
	public void sendMessage(String message) {
		kafkaTemplate.send(strTopic, message).addCallback(
				success -> {
					if (success != null) {
						log.info("Send message with success {}", message);
						log.info("Partition {}, Offset {}", 
								success.getRecordMetadata().partition(),
								success.getRecordMetadata().offset());
					}
				},
				error -> log.error("Error send message")
				);
	}
}
