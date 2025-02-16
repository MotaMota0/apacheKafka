package com.javaguru.ProgramKafka.controller;


import com.javaguru.ProgramKafka.service.ProductService;
import com.javaguru.ProgramKafka.service.dto.CreateProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDTO createProductDTO) throws ExecutionException, InterruptedException {
        String productId= productService.createProduct(createProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}
