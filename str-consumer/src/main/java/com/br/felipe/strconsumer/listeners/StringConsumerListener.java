package com.br.felipe.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.br.felipe.strconsumer.custom.StringConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StringConsumerListener {
		
	@StringConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}
}
