package com.trungtiendo.jasyptspringexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ExampleService {

    private final Logger logger = LoggerFactory.getLogger(ExampleService.class);

    @Value("${application.client_id}")
    private String clientId;

    @Value("${application.client_secret}")
    private String clientSecret;

    @Value("${application.no_decrypt.id}")
    private String noDecryptId;

    @EventListener(ContextRefreshedEvent.class)
    public void applicationStartup() {
        logger.info("Decrypted client id is: {}", clientId);
        logger.info("Decrypted client secret is: {}", clientSecret);
        logger.info("No client id is: {}", noDecryptId);
    }
}
