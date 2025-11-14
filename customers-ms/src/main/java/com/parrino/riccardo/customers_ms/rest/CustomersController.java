package com.parrino.riccardo.customers_ms.rest;

import org.springframework.web.bind.annotation.RestController;

import com.parrino.riccardo.customers_ms.dto.CustomerDTO;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomersController {

    @PostMapping("")
    public Mono<String> createCustomer(@RequestBody CustomerDTO entity) {
        return Mono.just(new String("customers-ms createCustomer endpoint"));
    }

    @GetMapping("")
    public Mono<String> findAll() {
        return Mono.just(new String("customers-ms findAll endpoint"));
    }

    @GetMapping("{username}")
    public Mono<String> findCustomerByUsername(@PathVariable String username) {
        return Mono.just(new String("customers-ms findCustomerByUsername endpoint"));
    }

    @PatchMapping("{username}")
    public Mono<String> updateCustomerByUsername(@PathVariable String username, CustomerDTO updateCustomer) {
        return Mono.just(new String("customers-ms updateCustomerByUsername endpoint"));
    }

    @DeleteMapping("{username}")
    public Mono<String> deleteCustomerByUsername(@PathVariable String username) {
        return Mono.just(new String("customers-ms deleteCustomerByUsername endpoint"));
    }

}
