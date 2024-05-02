package com.br.felipe.paymentservice.resources.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.felipe.paymentservice.model.Payment;
import com.br.felipe.paymentservice.resources.PaymentResource;
import com.br.felipe.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentResourceImpl implements PaymentResource {
	
	private final PaymentService paymentService;

	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
