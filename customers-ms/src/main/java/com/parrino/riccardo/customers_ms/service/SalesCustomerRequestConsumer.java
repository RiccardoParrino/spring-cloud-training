package com.parrino.riccardo.customers_ms.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.customers_ms.record.SalesConsumerRequest;

@Component
public class SalesCustomerRequestConsumer {

    @Bean
    public Consumer<SalesConsumerRequest> salesCustomerRequest() {
        return (event) -> {
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("id: " + event.id());
            System.out.println("customerId: " + event.customerId());
        };
    }

}
