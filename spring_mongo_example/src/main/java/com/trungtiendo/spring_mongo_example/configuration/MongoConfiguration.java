package com.trungtiendo.spring_mongo_example.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoClientSettingsBuilderCustomizer mongoClientSettingsBuilderCustomizer() {
        return (clientSettingsBuilder) -> {
            clientSettingsBuilder
                    .retryWrites(false)
                    .applyToSslSettings(builder -> builder.invalidHostNameAllowed(true));
        };
    }
}
