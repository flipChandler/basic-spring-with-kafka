package com.br.felipe.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.br.felipe.strconsumer.custom.StringConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StringConsumerListener {
		
	@StringConsumerCustomListener(groupId = "${app.config.kafka.group.group-1}")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@StringConsumerCustomListener(groupId = "${app.config.kafka.group.group-1}")
	public void testErrorHandler(String message) {
		log.info("TEST_ERROR_HANDLER ::: Receive message {}", message);
		throw new IllegalArgumentException();
	}
	
	@KafkaListener(groupId = "${app.config.kafka.group.group-2}", topics = "${app.config.kafka.topic.str-topic}", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}
}
