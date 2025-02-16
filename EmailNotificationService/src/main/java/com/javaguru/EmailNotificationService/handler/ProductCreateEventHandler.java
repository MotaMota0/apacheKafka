package com.javaguru.EmailNotificationService.handler;

import com.javaguru.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "payment-created-events-topic")

public class ProductCreateEventHandler {


    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
     @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent ){
        LOGGER.info("Received event {} ",productCreatedEvent.getTitle());
    }

}
