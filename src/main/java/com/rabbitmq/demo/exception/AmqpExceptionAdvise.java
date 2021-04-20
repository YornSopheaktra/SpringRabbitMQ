/*
package com.rabbitmq.demo.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ConditionalOnProperty(value = "custom.base.exception.advice.enabled", matchIfMissing = true)
@ControllerAdvice
public class AmqpExceptionAdvise {

	@Autowired
	private AmqpTemplate amqpTemplate;


	@ExceptionHandler(MessageQueueException.class)
	public void handlerException(Throwable ex){
		System.out.println("send to deadQueue: "+ ex.getMessage());
		amqpTemplate.convertAndSend("test-payout-dead-queue", ex.getMessage());
	}

	@ExceptionHandler(AmqpRejectAndDontRequeueException.class)
	public void handlerAmqp(Throwable ex){
		System.out.println("send to deadQueue1: "+ ex.getMessage());
		amqpTemplate.convertAndSend("test-payout-dead-queue", ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public void handler(Throwable ex){
		if (ex instanceof MessageQueueException){
			System.out.println("Error class: "+ ex.getCause().getClass());
		}else if (ex instanceof AmqpRejectAndDontRequeueException){
			System.out.println("Error class1: "+ ex.getCause().getClass());
		}
		System.out.println("send to deadQueue1: "+ ex.getMessage());
		amqpTemplate.convertAndSend("test-payout-dead-queue", ex.getMessage());
	}

}
*/
