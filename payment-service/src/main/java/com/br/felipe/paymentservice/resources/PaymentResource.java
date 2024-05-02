package com.br.felipe.paymentservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.felipe.paymentservice.model.Payment;

public interface PaymentResource {
	
	@PostMapping
	ResponseEntity<Payment> payment(@RequestBody Payment payment);

}
