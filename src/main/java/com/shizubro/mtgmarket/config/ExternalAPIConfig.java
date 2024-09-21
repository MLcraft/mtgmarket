package com.shizubro.mtgmarket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="external")
@Data
public class ExternalAPIConfig {
    private String serra;
    private String hareruya;
    private String scryfall;
}
