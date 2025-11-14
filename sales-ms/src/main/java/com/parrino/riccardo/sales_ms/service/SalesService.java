package com.parrino.riccardo.sales_ms.service;

import java.util.HashSet;
import java.util.Set;
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

    private final ConcurrentHashMap<Long, Set<String>> verifiedServices = new ConcurrentHashMap<>();

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

    public void insertCheckedService(Long correlationId, String service) {
        if (this.verifiedServices.containsKey(correlationId)) {
            Set<String> checkedServicesSet = this.verifiedServices.get(correlationId);
            checkedServicesSet.add(service);
        } else {
            Set<String> newCheckedServicesSet = new HashSet<>();
            newCheckedServicesSet.add(service);
            this.verifiedServices.put(correlationId, newCheckedServicesSet);
        }
    }

    public void finalizeSale(Long correlationId) {
        Set<String> checkedServices = this.verifiedServices.get(correlationId);
        if (checkedServices.contains("productService") && checkedServices.contains("customerService")) {
            System.out.println("I can finalize the sale creation!");
            this.verifiedServices.remove(correlationId);
        } else {
            System.out.println("I cannot finalize the sale!");
        }
    }

}
