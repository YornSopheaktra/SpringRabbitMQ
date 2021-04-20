/*
package com.rabbitmq.demo.exception;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;

public class CustomFatalExceptionStrategy
		extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {
	@Override
	public boolean isFatal(Throwable t) {
		System.out.println("==================== error : " + t.getMessage());
		return !(t.getCause() instanceof MessageQueueException);
	}
}*/
