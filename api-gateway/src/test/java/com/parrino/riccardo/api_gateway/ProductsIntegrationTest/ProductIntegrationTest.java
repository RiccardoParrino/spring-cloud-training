package com.parrino.riccardo.api_gateway.ProductsIntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebTestClient
public class ProductIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void test_findAllProductEndpoint() {
        webTestClient.get()
                .uri("/products")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_findProductsByCodeEndpoint() {
        webTestClient.get()
                .uri("/products/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_deleteProductByCode() {
        webTestClient.delete()
                .uri("/products/1")
                .exchange()
                .expectStatus().isOk();
    }

}
