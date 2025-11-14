package com.parrino.riccardo.sales_ms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products-ms")
public interface ProductsFeignClient {

    @GetMapping("{code}")
    String findProductByCode(Long code);

}
