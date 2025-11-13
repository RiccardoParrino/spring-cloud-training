package com.parrino.riccardo.sales_ms.rest;

import org.springframework.web.bind.annotation.RestController;

import com.parrino.riccardo.sales_ms.dto.CreateSalesDTO;
import com.parrino.riccardo.sales_ms.dto.UpdateSalesDTO;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SalesController {

    @PostMapping("")
    public Mono<String> createSale(@RequestBody CreateSalesDTO sale) {
        return Mono.just(new String("sales-ms createSales endpoint"));
    }

    @GetMapping("")
    public Mono<String> findAllSales() {
        return Mono.just(new String("sales-ms findAllSales endpoint"));
    }

    @GetMapping("{salesCode}")
    public Mono<String> findSalesById(@PathVariable Long salesCode) {
        return Mono.just(new String("sales-ms findSalesById endpoint"));
    }

    @PatchMapping("{salesCode}")
    public Mono<String> updateSalesById(@PathVariable UpdateSalesDTO updateSalesDTO) {
        return Mono.just(new String("sales-ms updateSalesById endpoint"));
    }

    @DeleteMapping("{salesCode}")
    public Mono<String> deleteSalesById(@PathVariable Long salesCode) {
        return Mono.just(new String("sales-ms deleteSalesById endpoint"));
    }

}
