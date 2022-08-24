package com.schoolfeespayment.payment.mpesa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body{

	@JsonProperty("stkCallback")
	private StkCallback stkCallback;
}