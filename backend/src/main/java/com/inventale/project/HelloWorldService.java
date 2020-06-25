package com.inventale.project;

public class HelloWorldService {
    private final HelloWorldMessageProvider helloWorldMessageProvider;

    public HelloWorldService(HelloWorldMessageProvider helloWorldMessageProvider) {
        this.helloWorldMessageProvider = helloWorldMessageProvider;
    }

    public HelloWorldResult getHelloWorld() {
        return new HelloWorldResult(helloWorldMessageProvider.getMessage());
    }
}