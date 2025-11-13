package com.parrino.riccardo.sales_ms.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.parrino.riccardo.sales_ms.record.SalesProductResponse;

@Service
public class SalesProductResponseConsumer {
    @Bean
    public Consumer<SalesProductResponse> productResponseConsumed() {
        return event -> {
            System.out.println("Received products: " + event.productResponse());
        };
    }
}
