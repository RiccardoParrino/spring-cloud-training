package com.parrino.riccardo.sales_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parrino.riccardo.sales_ms.record.SalesProductRequest;

@Service
public class SalesService {

    @Autowired
    private SalesProductRequestProducer salesProductRequestProducer;

    public void sendProductRequest(Long id, Long productId) {
        salesProductRequestProducer
                .publishSalesProductRequest(
                        new SalesProductRequest(id, productId));
    }

}
