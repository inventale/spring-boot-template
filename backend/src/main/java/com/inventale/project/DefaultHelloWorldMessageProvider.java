package com.inventale.project;

import com.inventale.project.metrics.PrometheusMetrics;
import io.micrometer.core.annotation.Timed;

public class DefaultHelloWorldMessageProvider implements HelloWorldMessageProvider {
    private final String helloWorldTarget;

    public DefaultHelloWorldMessageProvider(String helloWorldTarget) {
        this.helloWorldTarget = helloWorldTarget;
    }

    // extra tags need to split time series to separate implementations:
    // default and dev message length will be stored in separate time series
    @Override
    @Timed(value = PrometheusMetrics.HELLO_WORLD_PROVIDER_TIMED, extraTags = {"implementation", "default"})
    public String getMessage() {
        return String.format("Hello world, %s", helloWorldTarget);
    }
}