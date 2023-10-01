package com.example.portalcartapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CartController.class)
public class CartControllerTest {
    @Autowired
    WebTestClient client;


    @Test
    public void testAddToCart() throws Exception {
        WebTestClient.ResponseSpec response = client.post().uri("/cart/v1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just("http://localhost:8020/cart/v1/123456"), String.class)
                .exchange();

        response.expectStatus().isCreated();
    }
}
