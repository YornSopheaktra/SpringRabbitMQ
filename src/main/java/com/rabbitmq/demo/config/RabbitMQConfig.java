package com.rabbitmq.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

	 @Value("${rabbitmq.queue}")
	public String QUEUE;

	@Value("${rabbitmq.dead.queue}")
	public String DEAD_QUEUE;

	@Value("${rabbitmq.exchange.queue}")
	private String EXCHANGE_NAME;

	@Value("${rabbitmq.dead-message-ttl}")
	private Long MESSAGE_DEAD_TTL;

	@Value("${rabbitmq.message-ttl}")
	private Long MESSAGE_TTL;


	@Bean
	public Queue queue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", EXCHANGE_NAME);
		arguments.put("x-dead-letter-routing-key", DEAD_QUEUE);
		arguments.put("x-message-ttl", MESSAGE_TTL);
		return new Queue(QUEUE, true, false, false, arguments);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	@Bean
	Queue deadQueue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-message-ttl", MESSAGE_DEAD_TTL);
		return new Queue(DEAD_QUEUE, true, false, false, arguments);
	}

	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE);
	}

	@Bean
	public Binding bindingDeadLetter(Queue deadQueue, DirectExchange exchange) {
		return BindingBuilder.bind(deadQueue).to(exchange).with(DEAD_QUEUE);
	}


	//------------Queue 1 config
	@Bean
	public Queue queue1() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", EXCHANGE_NAME);
		arguments.put("x-dead-letter-routing-key", DEAD_QUEUE);
		arguments.put("x-message-ttl", MESSAGE_TTL);
		return new Queue(QUEUE+"-01", true, false, false, arguments);
	}

	//------------Queue 2 config
	@Bean
	public Queue queue2() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", EXCHANGE_NAME);
		arguments.put("x-dead-letter-routing-key", DEAD_QUEUE);
		arguments.put("x-message-ttl", MESSAGE_TTL);
		return new Queue(QUEUE+ "-02", true, false, false, arguments);
	}

}
