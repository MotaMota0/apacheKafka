package com.javaguru.ProgramKafka.service;

import com.javaguru.ProgramKafka.service.dto.CreateProductDTO;

import com.javaguru.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService{


    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    public ProductServiceImpl(KafkaTemplate <String ,ProductCreatedEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Override
    public String createProduct(CreateProductDTO createProductDTO) throws ExecutionException, InterruptedException {


        //

        String productID = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productID ,createProductDTO.getTitle(),
                createProductDTO.getPrice(),createProductDTO.getQuantity());



       SendResult<String,ProductCreatedEvent> result  = kafkaTemplate
                .send("payment-created-events-topic",productID,productCreatedEvent).get();

       LOGGER.info("Result {} :",result.getRecordMetadata().topic());
       LOGGER.info("Result {} :",result.getRecordMetadata().partition());
       LOGGER.info("Result {} :",result.getRecordMetadata().offset());

        LOGGER.info("Return {} ",productID);



        return productID;
    }
}
