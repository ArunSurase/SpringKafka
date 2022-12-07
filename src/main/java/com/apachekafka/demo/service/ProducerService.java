package com.apachekafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.apachekafka.demo.entity.Order;

@Service
public class ProducerService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	KafkaTemplate<String, Order> kafkaTemplate1;
	
	public void sendMessage(String message)
	{
		kafkaTemplate.send("producer-message",message);
	}
	
	public void sendOrder(Order order)
	{
		kafkaTemplate1.send("producer",order);
	}
}
