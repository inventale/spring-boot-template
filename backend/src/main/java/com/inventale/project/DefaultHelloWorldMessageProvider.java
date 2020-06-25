package com.inventale.project;

public class DefaultHelloWorldMessageProvider implements HelloWorldMessageProvider {
    private final String helloWorldTarget;

    public DefaultHelloWorldMessageProvider(String helloWorldTarget) {
        this.helloWorldTarget = helloWorldTarget;
    }

    @Override
    public String getMessage() {
        return String.format("Hello world, %s", helloWorldTarget);
    }
}