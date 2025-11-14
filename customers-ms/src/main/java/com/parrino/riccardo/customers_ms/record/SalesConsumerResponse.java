package com.parrino.riccardo.customers_ms.record;

public record SalesConsumerResponse(Long correlationId, Long id, Long customerId, Boolean salesConsumerResponse) {
}
