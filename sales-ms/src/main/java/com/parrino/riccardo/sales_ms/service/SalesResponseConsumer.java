package com.parrino.riccardo.sales_ms.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.sales_ms.record.SalesCustomerResponse;
import com.parrino.riccardo.sales_ms.record.SalesProductResponse;

@Component
public class SalesResponseConsumer {

    @Bean
    Consumer<SalesCustomerResponse> salesCustomerResponse() {
        return (event) -> {
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("id: " + event.id());
            System.out.println("customerId" + event.customerId());
            System.out.println("salesConsumerResponse: " + event.salesConsumerResponse());
        };
    }

    @Bean
    Consumer<SalesProductResponse> salesProductResponse() {
        return (event) -> {
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("productId: " + event.productId());
            System.out.println("salesProductResponse: " + event.salesProductResponse());
        };
    }

}
