package com.parrino.riccardo.sales_ms.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSalesDTO {
    private Long salesCode;
    private Long customerId;
    private Long productId;
    private Date saleDate;
    private String method;
}
