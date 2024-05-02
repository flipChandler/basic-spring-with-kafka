package com.br.felipe.paymentservice.service;

import com.br.felipe.paymentservice.model.Payment;

public interface PaymentService {
	
	void sendPayment(Payment payment);
}
