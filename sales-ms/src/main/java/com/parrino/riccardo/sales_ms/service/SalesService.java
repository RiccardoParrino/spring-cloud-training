package com.parrino.riccardo.sales_ms.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parrino.riccardo.sales_ms.record.SalesCustomerRequest;
import com.parrino.riccardo.sales_ms.record.SalesProductRequest;

@Service
public class SalesService {

    @Autowired
    private SalesProductRequestProducer salesProductRequestProducer;

    @Autowired
    private SalesCustomerRequestProducer salesCustomerRequestProducer;

    public void sendProductRequest(Long correlationId, Long id, Long productId) {
        salesProductRequestProducer
                .publishSalesProductRequest(
                        new SalesProductRequest(correlationId, id, productId));
    }

    public void sendCustomerRequest(Long correlationId, Long id, Long customerId) {
        salesCustomerRequestProducer
                .publishSalesCustomerRequest(
                        new SalesCustomerRequest(correlationId, id, customerId));
    }

}
