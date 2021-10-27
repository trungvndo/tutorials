package com.trungtiendo.spring_mongo_example.endpoints;

import org.bson.Document;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomMongoHealthIndicator implements HealthIndicator {

    private final MongoTemplate mongoTemplate;

    public CustomMongoHealthIndicator(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Health health() {
        Document result = this.mongoTemplate.executeCommand("{serverStatus: 1}");
        Health.Builder builder = new Health.Builder();
        return builder.up()
                .withDetail("version", result.get("version"))
                .withDetail("uptime", result.get("uptime"))
                .build();
    }
}
