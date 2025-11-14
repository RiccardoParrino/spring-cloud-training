package com.parrino.riccardo.sales_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.parrino.riccardo.sales_ms.record.SalesCustomerRequest;

@Service
public class SalesCustomerRequestProducer {

    @Autowired
    private StreamBridge streamBridge;

    public void publishSalesCustomerRequest(SalesCustomerRequest salesCustomerRequest) {
        streamBridge.send("salesCustomerRequest-out-0", salesCustomerRequest);
    }

}
