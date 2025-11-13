package com.parrino.riccardo.sales_ms.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.sales_ms.record.SalesProductResponse;

@Component
public class SalesProductResponseConsumer {

    @Bean
    Consumer<SalesProductResponse> salesProductResponse() {
        return (event) -> {
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("productId: " + event.productId());
            System.out.println("salesProductResponse: " + event.salesProductResponse());
        };
    }

}
