package com.example.resourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Value("${keySetURI}")
    private String keySetUri;

    @Value("${introspectionUri}")
    private String introspectionUri;

    @Value("${resourceserver.clientId}")
    private String clientId;

    @Value("${resourceserver.secret}")
    private String clientSecret;

    private final JwtAuthenticationConverter converter;

    public ProjectConfig(JwtAuthenticationConverter converter) {
        this.converter = converter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .oauth2ResourceServer(
//                c -> c.jwt(
//                    j -> j.jwkSetUri(keySetUri)
//                        .jwtAuthenticationConverter(converter)
//                )
                c -> c.opaqueToken(
                        o -> o.introspectionUri(introspectionUri)
                            .introspectionClientCredentials(clientId, clientSecret)
                )
            )
            .authorizeHttpRequests(
                c -> c.anyRequest().authenticated()
            );

        return http.build();
    }
}
