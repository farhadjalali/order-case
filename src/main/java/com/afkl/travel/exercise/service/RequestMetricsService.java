package com.afkl.travel.exercise.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RequestMetricsService {

    private final MeterRegistry meterRegistry;

    private final Counter totalRequestsCounter;
    private final Counter okResponsesCounter;
    private final Counter fourxxResponsesCounter;
    private final Counter fivexxResponsesCounter;
    private final Timer responseTimeTimer;

    public RequestMetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        totalRequestsCounter = meterRegistry.counter("requests.total");
        okResponsesCounter = meterRegistry.counter("responses.ok");
        fourxxResponsesCounter = meterRegistry.counter("responses.4xx");
        fivexxResponsesCounter = meterRegistry.counter("responses.5xx");
        responseTimeTimer = meterRegistry.timer("response.time");
    }

    public void incrementTotalRequests() {
        totalRequestsCounter.increment();
    }

    public void incrementOkResponses() {
        okResponsesCounter.increment();
    }

    public void increment4xxResponses() {
        fourxxResponsesCounter.increment();
    }

    public void increment5xxResponses() {
        fivexxResponsesCounter.increment();
    }

    public void recordResponseTime(long responseTime) {
        responseTimeTimer.record(responseTime, TimeUnit.MICROSECONDS);
    }
}
