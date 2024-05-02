package com.br.felipe.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.br.felipe.jsonconsumer.model.Payment;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class JsonListener {
	
	@SneakyThrows
	@KafkaListener(topics = "${app.config.kafka.topic.payment-topic}", groupId = "${app.config.kafka.group.create-group}", containerFactory = "jsonContainerFactory")
	public void antiFraud(@Payload Payment payment) {
		log.info("Payment received {}", payment.toString());
		Thread.sleep(2000);
		
		log.info("Validating fraud");
		Thread.sleep(2000);
		
		log.info("Purchase approved");
		Thread.sleep(2000);
	}
	
	@SneakyThrows
	@KafkaListener(topics = "${app.config.kafka.topic.payment-topic}", groupId = "${app.config.kafka.group.pdf-group}", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Payment payment) {
		Thread.sleep(3000);
		log.info("Creating PDF from productId {} ...", payment.getId());
		Thread.sleep(3000);
	}
	
	@SneakyThrows
	@KafkaListener(topics = "${app.config.kafka.topic.payment-topic}", groupId = "${app.config.kafka.group.email-group}", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		Thread.sleep(3000);
		log.info("Sending confirmation email ...");
	}
}
