package com.trungtiendo.resourceserverexample.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(
                    authorize -> authorize
                            .mvcMatchers(HttpMethod.GET, "/properties/**").hasAuthority("SCOPE_read")
                            .mvcMatchers(HttpMethod.POST, "/properties/**").hasAuthority("SCOPE_create")
                            .mvcMatchers(HttpMethod.PUT, "/properties/**").hasAuthority("SCOPE_update")
                    .anyRequest().authenticated()
            )
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::opaqueToken);
    }
}
