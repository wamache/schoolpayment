package com.schoolfeespayment.payment.mpesa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReferenceData{

	@JsonProperty("ReferenceItem")
	private ReferenceItem referenceItem;
}