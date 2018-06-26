package com.ekart.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class EKartZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(EKartZipkinApplication.class, args);
	}
}
