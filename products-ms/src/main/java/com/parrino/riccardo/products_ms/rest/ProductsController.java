package com.parrino.riccardo.products_ms.rest;

import org.springframework.web.bind.annotation.RestController;

import com.parrino.riccardo.products_ms.dto.CreateProductDTO;
import com.parrino.riccardo.products_ms.dto.UpdateProductDTO;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductsController {

    @PostMapping("")
    public Mono<String> createProduct(@RequestBody CreateProductDTO product) {
        return Mono.just(new String("products-ms createProduct endpoint"));
    }

    @GetMapping("")
    public Mono<String> findAllProduct() {
        return Mono.just(new String("products-ms findAllProduct endpoint"));
    }

    @GetMapping("{code}")
    public Mono<String> findProductByCode(@PathVariable Long code) {
        return Mono.just(new String("products-ms findProductByCode endpoint"));
    }

    @PatchMapping("{code}")
    public Mono<String> updateProductByCode(@PathVariable Long code, @RequestBody UpdateProductDTO product) {
        return Mono.just(new String("products-ms updateProductByCode endpoint"));
    }

    @DeleteMapping("{code}")
    public Mono<String> deleteProductByCode(@PathVariable Long code) {
        return Mono.just(new String("products-ms deleteProductByCode endpoint"));
    }

}
