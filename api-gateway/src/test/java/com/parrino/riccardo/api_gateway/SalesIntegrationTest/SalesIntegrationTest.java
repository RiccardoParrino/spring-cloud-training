package com.parrino.riccardo.api_gateway.SalesIntegrationTest;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebTestClient
public class SalesIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void test_findAllSalesEndpoint() {
        webTestClient.get()
                .uri("/sales")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_findSalesByIdEndpoint() {
        webTestClient.get()
                .uri("/sales/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_updateSalesByIdEndpoint() {
        webTestClient.patch()
                .uri("/sales/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_deleteSalesByCode() {
        webTestClient.delete()
                .uri("/sales/1")
                .exchange()
                .expectStatus().isOk();
    }

}
