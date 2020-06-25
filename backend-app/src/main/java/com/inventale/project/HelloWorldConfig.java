package com.inventale.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SuppressWarnings("unused")
@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorldService helloWorldService(
            HelloWorldMessageProvider helloWorldMessageProvider
    ) {
        return new HelloWorldService(helloWorldMessageProvider);
    }

    @Profile(ProfileNames.DEV)
    @Bean
    public HelloWorldMessageProvider devHelloWorldMessageProvider(
            @Value(value = "${backend.hello-world-target}") String helloWorldTarget
    ) {
        return new DevHelloWorldMessageProvider(helloWorldTarget);
    }

    @Profile("!" + ProfileNames.DEV)
    @Bean
    public HelloWorldMessageProvider defaultHelloWorldMessageProvider(
            @Value(value = "${backend.hello-world-target}") String helloWorldTarget
    ) {
        return new DefaultHelloWorldMessageProvider(helloWorldTarget);
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
    }
}
