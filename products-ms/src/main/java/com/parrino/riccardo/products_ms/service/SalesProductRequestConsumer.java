package com.parrino.riccardo.products_ms.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.products_ms.record.SalesProductRequest;

@Component
public class SalesProductRequestConsumer {

    @Bean
    public Consumer<SalesProductRequest> salesProductRequest() {
        return (event) -> {
            System.out.println("id: " + event.id());
            System.out.println("productId: " + event.productId());
        };
    }

}
