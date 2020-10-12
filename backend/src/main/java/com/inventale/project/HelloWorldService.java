package com.inventale.project;

import com.inventale.project.metrics.PrometheusMetrics;
import io.micrometer.core.instrument.Metrics;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloWorldService {
    private static final AtomicInteger LAST_MESSAGE_LETTERS = new AtomicInteger(0);

    private final transient HelloWorldMessageProvider helloWorldMessageProvider;

    public HelloWorldService(HelloWorldMessageProvider helloWorldMessageProvider) {
        this.helloWorldMessageProvider = helloWorldMessageProvider;
        // link AtomicInteger instance with metric. Every time the AtomicInteger is updated, metric will be changed.
        Metrics.gauge(PrometheusMetrics.HELLO_WORLD_LAST_MESSAGE_LETTERS_NUMBER, LAST_MESSAGE_LETTERS);
    }

    public HelloWorldResult getHelloWorld() {
        // increment counter
        Metrics.counter(PrometheusMetrics.HELLO_WORLD_COUNT).increment();
        String message = helloWorldMessageProvider.getMessage();
        // set gauge
        LAST_MESSAGE_LETTERS.set(message.length());
        return new HelloWorldResult(message);
    }
}