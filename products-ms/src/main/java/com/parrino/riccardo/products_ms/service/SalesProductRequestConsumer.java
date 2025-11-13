package com.parrino.riccardo.products_ms.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.products_ms.record.SalesProductRequest;
import com.parrino.riccardo.products_ms.record.SalesProductResponse;

@Component
public class SalesProductRequestConsumer {

    @Autowired
    private StreamBridge streamBridge;

    @Bean
    public Consumer<SalesProductRequest> salesProductRequest() {
        return (event) -> {
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("id: " + event.id());
            System.out.println("productId: " + event.productId());

            streamBridge.send("salesProductResponse-out-0",
                    new SalesProductResponse(event.correlationId(), event.productId(), true));
        };
    }

}
