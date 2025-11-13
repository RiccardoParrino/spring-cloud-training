package com.parrino.riccardo.sales_ms.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.sales_ms.record.SalesCustomerResponse;

@Component
public class SalesCustomerResponseConsumer {

    @Bean
    Consumer<SalesCustomerResponse> salesCustomerResponse() {
        return (event) -> {
            System.out.println("ciaooo");
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("id: " + event.id());
            System.out.println("customerId" + event.customerId());
            System.out.println("salesConsumerResponse: " + event.salesConsumerResponse());
        };
    }

}
