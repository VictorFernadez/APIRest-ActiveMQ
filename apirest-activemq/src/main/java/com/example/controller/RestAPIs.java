package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jms.producer.JmsProducer;
import com.example.model.Customer;
import com.example.model.MessageStorage;

@RestController
public class RestAPIs {

	@Autowired
	JmsProducer jmsProducer;
	@Autowired
	private MessageStorage messageStorage;

	@PostMapping(value = "/api/customer")
	public Customer postCustomer(@RequestBody Customer customer) {
		jmsProducer.send(customer);
		return customer;
	}

	@GetMapping(value = "/api/customers")
	public List<Customer> getAll() {
		List<Customer> customers = messageStorage.getAll();
		return customers;
	}

	@DeleteMapping(value = "/api/customers/clear")
	public String clearCustomer() {
		messageStorage.clear();
		return "Clear All CustomerStorage";
	}
}
