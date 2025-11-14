package com.parrino.riccardo.sales_ms.webClient;

import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ProductsWebClient {

    private final WebClient webClient;
    private final ReactiveCircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public ProductsWebClient(WebClient.Builder webClientBuilder,
            ReactiveCircuitBreakerFactory<?, ?> circuitBreakerFactory) {
        this.webClient = webClientBuilder.build();
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public Mono<String> findProductByCode(Long code) {
        return circuitBreakerFactory.create("productsMS").run(
                webClient.get()
                        .uri("http://products-ms/{code}", code)
                        .retrieve()
                        .bodyToMono(String.class),
                throwable -> Mono.just("productsMS not reachable"));
    }

}
