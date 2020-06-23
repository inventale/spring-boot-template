package com.inventale.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("unused")
@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorldService helloWorldService(
            @Value(value = "${backend.hello-world-target}") String helloWorldTarget
    ) {
        return new HelloWorldService(helloWorldTarget);
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
    }
}
