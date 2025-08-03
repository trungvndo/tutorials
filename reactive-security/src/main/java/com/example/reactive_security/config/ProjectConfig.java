package com.example.reactive_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class ProjectConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.authorizeExchange(
                c -> c.pathMatchers(HttpMethod.GET, "/hello")
                        .authenticated()
                        .anyExchange().permitAll()
        );

        return httpSecurity.build();
    }


                                                         @Bean
    public ReactiveUserDetailsService userDetailsService() {
        UserDetails u = User.withUsername("john")
                .password("password")
                .authorities("read")
                .build();

        return new MapReactiveUserDetailsService(u);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
