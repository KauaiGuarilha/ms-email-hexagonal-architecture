package com.ms.email.adapters.inbound.consumer;

import com.ms.email.adapters.dto.EmailDTO;
import com.ms.email.application.domain.Email;
import com.ms.email.application.port.EmailServicePort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired EmailServicePort emailServicePort;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDto) {
        Email email = new Email();

        BeanUtils.copyProperties(emailDto, email);
        emailServicePort.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail().toString());
    }
}
