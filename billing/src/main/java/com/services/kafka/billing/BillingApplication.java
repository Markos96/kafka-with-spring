package com.services.kafka.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BillingApplication {
	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}
}
