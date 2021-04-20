package com.rabbitmq.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class AmqpController {


	@Autowired
	private AmqpTemplate restTemplate;

	@Value("${rabbitmq.queue}")
	String queueName;

	@PostMapping("/public/message")
	public ResponseEntity publicMessageToQueue() {

		HashMap<String, Object> data = new HashMap<>();


		List<String> messages = Arrays.asList("hello", "hi", "what's up", "guys", "deal", "you");
		int i = 0;
		for (String message : messages) {
			String queues = queueName;
			if (i > 0) {
				queues = queues += "-0" + i;
			}
			i++;
			if (i == 3)
				i = 0;
			restTemplate.convertAndSend(queues, message);
			data.put(message, "key");
			System.out.println("{send to queue}: =>" + queues + "message: " + message);
		}
		return ResponseEntity.ok(data);
	}
}
