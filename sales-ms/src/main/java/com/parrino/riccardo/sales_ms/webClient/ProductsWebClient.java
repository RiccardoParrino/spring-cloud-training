package com.parrino.riccardo.sales_ms.webClient;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ProductsWebClient {

    private final WebClient webClient;

    public ProductsWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> findProductByCode(Long code) {
        return webClient.get()
                .uri("http://products-ms/{code}", code)
                .retrieve()
                .bodyToMono(String.class);
    }

}
