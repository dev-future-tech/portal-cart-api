package com.example.portalcartapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@RequestMapping("/cart/v1")
@RestController
public class CartController {

    @PostMapping
    public Mono<ResponseEntity<Void>> addProductToCart(UriComponentsBuilder componentsBuilder) {
        URI location = componentsBuilder.path("/cart/vi/{id}").buildAndExpand("123456").toUri();
        return Mono.just(ResponseEntity.created(location).build());
    }
}
