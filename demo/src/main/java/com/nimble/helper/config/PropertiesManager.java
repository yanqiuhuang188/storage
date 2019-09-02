package com.nimble.helper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix="custom-properties")
public class PropertiesManager {
    private String quartzExpression;

    public String getQuartzExpression() {
        return quartzExpression;
    }

    public void setQuartzExpression(String quartzExpression) {
        this.quartzExpression = quartzExpression;
    }
}
