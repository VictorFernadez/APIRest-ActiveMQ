package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ApirestActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestActivemqApplication.class, args);
	}

}
