package com.parrino.riccardo.sales_ms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.parrino.riccardo.sales_ms.config.FeignConfig;

@FeignClient(name = "products-ms", configuration = FeignConfig.class)
public interface ProductsFeignClient {

    @GetMapping("{code}")
    String findProductByCode(Long code);

}
