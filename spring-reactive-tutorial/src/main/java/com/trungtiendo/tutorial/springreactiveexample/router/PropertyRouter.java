package com.trungtiendo.tutorial.springreactiveexample.router;

import com.trungtiendo.tutorial.springreactiveexample.handler.PropertyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class PropertyRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PropertyHandler propertyHandler) {
        return RouterFunctions
                .route(GET("/property").and(accept(MediaType.APPLICATION_JSON))
                        ,propertyHandler::getProperty);
    }
}
