package com.ekart.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
@PropertySource(value = { "classpath:configuration.properties" })
public class EKartUserMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(EKartUserMSApplication.class, args);
	}
}
