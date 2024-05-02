package com.br.felipe.paymentservice.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.br.felipe.paymentservice.model.Payment;
import com.br.felipe.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	
	private final KafkaTemplate<String, Serializable> kafkaTemplate;
	
	@Value("${app-config.topic.payment-topic}")
	private String paymentTopic;
	
	@SneakyThrows
	@Override
	public void sendPayment(Payment payment) {
		log.info("Payment received {}", payment);
		Thread.sleep(1000);
		
		log.info("Enviando pagamento...");
		kafkaTemplate.send(paymentTopic, payment);
	}

}
