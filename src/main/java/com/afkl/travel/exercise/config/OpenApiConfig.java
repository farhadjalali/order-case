package com.afkl.travel.exercise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig {

    @Value("${afkl.openapi.dev-url}")
    private String devUrl;

    @Value("${afkl.openapi.prod-url}")
    private String prodUrl;

    public String getApiUrl(String environment) {
        if ("dev".equals(environment)) {
            return devUrl;
        } else if ("prod".equals(environment)) {
            return prodUrl;
        }
        return null; // or handle default case
    }
}
