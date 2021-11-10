package com.custom_condition_example.custom_condition_example.configuration;

import com.custom_condition_example.custom_condition_example.annotation.ConditionalOnPropertyContainingSubstring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @ConditionalOnProperty(prefix = "application", name = "city")
    @Bean
    public CustomClass customBean1() {
        logger.info("bean 1 is created");
        return new CustomClass();
    }

    @ConditionalOnProperty(prefix = "application", name = "city", havingValue = "melbourne")
    @Bean
    public CustomClass customBean2() {
        logger.info("bean 2 is created");
        return new CustomClass();
    }

    @ConditionalOnProperty(prefix = "application", name = "city", havingValue = "sydney")
    @Bean
    public CustomClass customBean3() {
        logger.info("bean 3 is created");
        return new CustomClass();
    }

    @ConditionalOnProperty(prefix = "application", name = "state", matchIfMissing = true)
    @Bean
    public CustomClass customBean4() {
        logger.info("bean 4 is created");
        return new CustomClass();
    }

    @ConditionalOnPropertyContainingSubstring(prefix = "application", name = "country", containingString = "Australia")
    @Bean
    public CustomClass customBean5() {
        logger.info("bean 5 is created");
        return new CustomClass();
    }

    @ConditionalOnPropertyContainingSubstring(prefix = "application", name = "country", containingString = "NZ")
    @Bean
    public CustomClass customBean6() {
        logger.info("bean 6 is created");
        return new CustomClass();
    }

    @ConditionalOnPropertyContainingSubstring(prefix = "application", name = "country", containingString = "UK")
    @Bean
    public CustomClass customBean7() {
        logger.info("bean 7 is created");
        return new CustomClass();
    }
}

class CustomClass {

}
