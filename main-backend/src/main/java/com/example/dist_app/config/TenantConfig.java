package com.example.dist_app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Configuration class for tenant-specific settings.
 * Maps tenant identifiers to their corresponding product categories,
 * enabling multi-tenant filtering of the product catalog.
 */
@Configuration
@ConfigurationProperties(prefix = "tenant")
public class TenantConfig {
    /**
     * Map of tenant IDs to their assigned product categories.
     */
    private Map<String, String> mapping;

    /**
     * Returns the tenant-to-category mapping.
     *
     * @return a map of tenant IDs to category names
     */
    public Map<String, String> getMapping() {
        return this.mapping;
    }

    /**
     * Sets the tenant-to-category mapping.
     *
     * @param mapping a map of tenant IDs to category names
     */
    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
