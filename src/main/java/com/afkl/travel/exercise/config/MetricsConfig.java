package com.afkl.travel.exercise.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public MeterRegistry meterRegistry() {
        CollectorRegistry collectorRegistry = new CollectorRegistry();
        return new PrometheusMeterRegistry((PrometheusConfig) collectorRegistry);
    }
}
