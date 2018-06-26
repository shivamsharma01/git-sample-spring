package com.ekart.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource(value = { "classpath:configuration.properties" })
public class EKartSellerMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(EKartSellerMSApplication.class, args);
	}
}
