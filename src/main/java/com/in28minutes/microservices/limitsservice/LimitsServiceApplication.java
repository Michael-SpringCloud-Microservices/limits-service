package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

	
	@RefreshScope
	@RestController
	class MessageRestController {

		@Value("${minimum}")
		private int minimum;

		@Value("${maximum}")
		private int maximum;

	}
}
