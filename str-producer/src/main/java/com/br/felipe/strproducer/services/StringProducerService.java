package com.br.felipe.strproducer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StringProducerService {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${app-config.topic.str-topic}")
	private String strTopic;
	
	public void sendMessage(String message) {
		kafkaTemplate.send(strTopic, message);
	}
}
