package com.rabbitmq.demo.config;

import com.rabbitmq.demo.exception.MessageQueueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener{


	@RabbitListener(queues = "multiple-queue")
	public void processMessages(Message message) throws MessageQueueException {
		System.out.println("===============Received message: {}" + message.toString());
		throw new MessageQueueException(message.toString(), new Throwable());
	}

	@RabbitListener(queues = "multiple-queue-01")
	public void processMessages1(Message message) throws MessageQueueException {
		System.out.println("++++++++++++++Received message1: {}" + message.toString());
		throw new MessageQueueException(message.toString(), new Throwable());
	}


	@RabbitListener(queues = "multiple-queue-02")
	public void processMessages2(Message message) throws MessageQueueException {
		System.out.println("################ Received message2: {}" +message.toString());
		throw new MessageQueueException(message.toString(), new Throwable());
	}
}
