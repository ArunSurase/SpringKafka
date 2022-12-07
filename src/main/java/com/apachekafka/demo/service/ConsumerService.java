package com.apachekafka.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apachekafka.demo.entity.Order;

@Service
public class ConsumerService {

	@KafkaListener(topics = "producer-message", groupId = "consumer-group1")
	public void listenTopic(String receivedMessage)
	{
		System.out.println(receivedMessage);
	}
	@KafkaListener(topics = "producer", groupId = "consumer-group2")
	public void listenTopic(Order order) {
		System.out.println("Message Received : ");
		System.out.println(order);
	}
}
