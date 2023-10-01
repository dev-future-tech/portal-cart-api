package com.example.portalcartapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@RequestMapping("/cart/v1")
@RestController
public class CartController {

    private Logger log = LoggerFactory.getLogger(getClass().getCanonicalName());

    @PostMapping
    public Mono<ResponseEntity<Void>> addProductToCart(@RequestHeader(name = "X-Customer-ID", required = false) String customerId,
                                                       UriComponentsBuilder componentsBuilder) {
        if(customerId != null) {
            log.debug("Managing cart for customer {}", customerId);
        } else {
            log.debug("CustomerId not present");
        }
        URI location = componentsBuilder.path("/cart/vi/{id}").buildAndExpand("123456").toUri();
        return Mono.just(ResponseEntity.created(location).build());
    }
}
