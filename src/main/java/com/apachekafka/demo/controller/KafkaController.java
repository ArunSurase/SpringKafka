package com.apachekafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafka.demo.entity.Order;
import com.apachekafka.demo.service.ProducerService;

@RestController
@RequestMapping("/rest/api")
public class KafkaController {
	
	@Autowired
	ProducerService producerService;

	@GetMapping("/producermsg")
	public String messageProducer(@RequestParam("message") String message)
	{
		producerService.sendMessage(message);
		return "Message sent to topic successfully";
	}
	
	@PostMapping("/producer")
	public String provider(@RequestBody Order order) {
		order.setOrderId("10001");
		producerService.sendOrder(order);
		return "Order sent";
	}
}
