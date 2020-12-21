package com.example.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.model.Customer;
import com.example.model.MessageStorage;

@Component
public class JmsConsumer {
	@Autowired
	private MessageStorage messageStorage;

	@JmsListener(destination = "${gkz.activemq.queue}",containerFactory = "jsaFactory")
	public void receive(Customer customer) {
		System.out.println("Received Message : " + customer.toString());
		messageStorage.addCustomer(customer);
	}
}
