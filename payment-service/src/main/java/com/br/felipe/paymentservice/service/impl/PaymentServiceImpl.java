package com.br.felipe.paymentservice.service.impl;

import org.springframework.stereotype.Service;

import com.br.felipe.paymentservice.model.Payment;
import com.br.felipe.paymentservice.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public void sendPayment(Payment payment) {
		log.info("PAYMENT_SERVICE_IMPL ::: Payment received {}", payment);
	}

}
