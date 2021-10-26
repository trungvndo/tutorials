package com.trungtiendo.spring_mongo_example.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListener {

    Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @EventListener(ContextRefreshedEvent.class)
    public void initIndicesOnStartup() {
        MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext =
                mongoTemplate.getConverter().getMappingContext();

        IndexResolver indexResolver = new MongoPersistentEntityIndexResolver(mappingContext);

        // retrieve entities that have @Document annotation
        mappingContext.getPersistentEntities()
                .stream()
                .filter(entity -> entity.isAnnotationPresent(Document.class))
                .forEach(entity -> {
                    IndexOperations indexOperations = mongoTemplate.indexOps(entity.getType());
                    logger.info("Creating index for {}", entity.getType());
                    indexResolver.resolveIndexFor(entity.getType()).forEach(indexOperations::ensureIndex);
                });
    }
}
