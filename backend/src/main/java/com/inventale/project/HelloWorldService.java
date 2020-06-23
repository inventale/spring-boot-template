package com.inventale.project;

public class HelloWorldService {
    private final String helloWorldTarget;

    public HelloWorldService(String helloWorldTarget) {
        this.helloWorldTarget = helloWorldTarget;
    }

    public HelloWorldResult getHelloWorld() {
        return new HelloWorldResult("Hello world, " + helloWorldTarget);
    }
}