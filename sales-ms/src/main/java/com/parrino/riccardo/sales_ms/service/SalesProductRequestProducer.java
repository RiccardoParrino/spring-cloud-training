package com.parrino.riccardo.sales_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.parrino.riccardo.sales_ms.record.SalesProductRequest;

@Service
public class SalesProductRequestProducer {

    @Autowired
    private StreamBridge streamBridge;

    public void publishSalesProductRequest(SalesProductRequest saleProductRequest) {
        streamBridge.send("salesProductRequest-out-0", saleProductRequest);
    }

}
