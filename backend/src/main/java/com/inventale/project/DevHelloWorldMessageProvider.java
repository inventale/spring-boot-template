package com.inventale.project;

import java.time.Instant;

public class DevHelloWorldMessageProvider implements HelloWorldMessageProvider {
    private final String helloWorldTarget;

    public DevHelloWorldMessageProvider(String helloWorldTarget) {
        this.helloWorldTarget = helloWorldTarget;
    }

    @Override
    public String getMessage() {
        return String.format("Hello world, %s, current time [%s]", helloWorldTarget, Instant.now());
    }
}