package com.parrino.riccardo.customers_ms.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.parrino.riccardo.customers_ms.record.SalesConsumerRequest;
import com.parrino.riccardo.customers_ms.record.SalesConsumerResponse;

@Component
public class SalesCustomerRequestConsumer {

    @Autowired
    private StreamBridge streamBridge;

    @Bean
    Consumer<SalesConsumerRequest> salesCustomerRequest() {
        return (event) -> {
            System.out.println("correlationId: " + event.correlationId());
            System.out.println("id: " + event.id());
            System.out.println("customerId: " + event.customerId());

            streamBridge.send("salesCustomerResponse-out-0",
                    new SalesConsumerResponse(event.correlationId(), event.id(), event.customerId(), true));
        };
    }

}
