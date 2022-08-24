package com.schoolfeespayment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schoolfeespayment.payment.mpesa.dtos.AcknowledgeResponse;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolfeespaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolfeespaymentApplication.class, args);
	}

	@Bean
	public OkHttpClient getOkHttpClient() {
		return new OkHttpClient ();
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper ();
	}

	@Bean
	public AcknowledgeResponse getAcknowledgeResponse() {
		AcknowledgeResponse acknowledgeResponse = new AcknowledgeResponse ();
		acknowledgeResponse.setMessage("Success");
		return acknowledgeResponse;
	}


}
