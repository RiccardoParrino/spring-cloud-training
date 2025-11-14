package com.parrino.riccardo.sales_ms.model;

public enum PaymentMethodEnum {
    CASH("cash"),
    CREDIT_CARD("credit_card"),
    RATE("rate");

    private String method;

    private PaymentMethodEnum(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
