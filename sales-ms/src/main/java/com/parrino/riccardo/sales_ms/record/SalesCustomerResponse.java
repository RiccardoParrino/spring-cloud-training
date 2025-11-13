package com.parrino.riccardo.sales_ms.record;

public record SalesCustomerResponse(Long correlationId, Long id, Long customerId, Boolean salesConsumerResponse) {

}
