package com.rabbitmq.demo.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

public class MessageQueueException extends Exception {
	private static final long serialVersionUID = -3154618962130084535L;

	public MessageQueueException(String message, Throwable t) {
		super(message);
		throw new AmqpRejectAndDontRequeueException(message);
	}
}
