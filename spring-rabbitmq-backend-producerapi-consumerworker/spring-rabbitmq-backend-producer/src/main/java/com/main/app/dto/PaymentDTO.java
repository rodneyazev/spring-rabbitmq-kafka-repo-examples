package com.main.app.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
	private String order;
	private BigDecimal price;
	private String product;
}
