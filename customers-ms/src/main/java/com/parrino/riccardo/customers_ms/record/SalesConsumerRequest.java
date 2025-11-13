package com.parrino.riccardo.customers_ms.record;

public record SalesConsumerRequest(Long correlationId, Long id, Long customerId) {
}