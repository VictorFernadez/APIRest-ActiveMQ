package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.MessageStorage;

@Configuration
public class BeanConfiguration {
	@Bean
	public MessageStorage messageStorage() {
		return new MessageStorage();
	}
}
