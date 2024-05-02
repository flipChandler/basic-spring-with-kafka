package com.br.felipe.jsonconsumer.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long userId;
	private Long productId;
	private String cardNumber;
	
}
