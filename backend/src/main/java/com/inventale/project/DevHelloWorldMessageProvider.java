package com.inventale.project;

import com.inventale.project.metrics.PrometheusMetrics;
import io.micrometer.core.annotation.Timed;

import java.time.Instant;

public class DevHelloWorldMessageProvider implements HelloWorldMessageProvider {
    private final String helloWorldTarget;

    public DevHelloWorldMessageProvider(String helloWorldTarget) {
        this.helloWorldTarget = helloWorldTarget;
    }

    @Override
    @Timed(value = PrometheusMetrics.HELLO_WORLD_PROVIDER_TIMED, extraTags = {"implementation", "dev"})
    public String getMessage() {
        return String.format("Hello world, %s, current time [%s]", helloWorldTarget, Instant.now());
    }
}