package com.example.demo.config;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.util.UUID;

@Configuration
public class ClientConfig {

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient client1 =
                RegisteredClient
                        .withId(UUID.randomUUID().toString())
                        .clientId("client")
                        .clientSecret("secret")
                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                        )
                        .authorizationGrantType(
                                AuthorizationGrantType.AUTHORIZATION_CODE
                        )
                        .redirectUri("https://www.manning.com/authorized")
                        .scope(OidcScopes.OPENID)
                        .build();

        RegisteredClient client2 =
                RegisteredClient
                        .withId(UUID.randomUUID().toString())
                        .clientId("client2")
                        .clientSecret("secret2")
                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                        )
                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                        .scope("custom")
                        .build();

        RegisteredClient client3 =
                RegisteredClient
                        .withId(UUID.randomUUID().toString())
                        .clientId("client3")
                        .clientSecret("secret3")
                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                        )
                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                        .tokenSettings(
                                TokenSettings.builder().accessTokenFormat(OAuth2TokenFormat.REFERENCE).build()
                        )
                        .scope("custom")
                        .build();

        RegisteredClient resourceServer =
                RegisteredClient
                        .withId(UUID.randomUUID().toString())
                        .clientId("resource_server")
                        .clientSecret("resource_server_secret")
                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                        )
                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                        .build();

        return new InMemoryRegisteredClientRepository(client1, client2, client3, resourceServer);
    }

}
