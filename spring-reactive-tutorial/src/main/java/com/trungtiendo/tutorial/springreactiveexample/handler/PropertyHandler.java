package com.trungtiendo.tutorial.springreactiveexample.handler;

import com.trungtiendo.tutorial.springreactiveexample.model.Property;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Random;

@Component
public class PropertyHandler {

    public Mono<ServerResponse> getProperty(ServerRequest request) {
        Property newProperty = new Property("Townhall", "George st", (new Random()).nextInt(100));
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(newProperty));
    }
}
