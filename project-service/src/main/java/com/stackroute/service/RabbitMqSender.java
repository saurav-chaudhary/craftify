package com.stackroute.service;

import com.stackroute.dto.ProjectDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingKey}")
    private String routingKey;

    public void send(ProjectDto projectDto) {
        rabbitTemplate.convertAndSend(this.exchange, this.routingKey, projectDto);
    }
}
