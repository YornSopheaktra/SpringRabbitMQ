package com.rabbitmq.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class amqpControllerTest {

    @Autowired
    private AmqpController amqpController;

    @Test
    void testPublicMessage() {
        amqpController.publicMessageToQueue();
    }
}
