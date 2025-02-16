package com.javaguru.ProgramKafka.service;

import com.javaguru.ProgramKafka.service.dto.CreateProductDTO;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(CreateProductDTO createProductDTO) throws ExecutionException, InterruptedException;
}
