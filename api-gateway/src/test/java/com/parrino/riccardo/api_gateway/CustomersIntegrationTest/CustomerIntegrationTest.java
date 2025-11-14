package com.parrino.riccardo.api_gateway.CustomersIntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebTestClient
public class CustomerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void test_findAllEndpoint() {
        webTestClient.get()
                .uri("/customers")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_findCustomerByUsernameEndpoint() {
        webTestClient.get()
                .uri("/customers/riccardo")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_updateCustomerByUsername() {
        webTestClient.patch()
                .uri("/customers/riccardo")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void test_deleteCustomerByUsername() {
        webTestClient.delete()
                .uri("/customers/riccardo")
                .exchange()
                .expectStatus().isOk();
    }

}
