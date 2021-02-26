package com.inventale.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.zalando.logbook.Sink;
import org.zalando.logbook.json.JsonHttpLogFormatter;
import org.zalando.logbook.logstash.LogstashLogbackSink;

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

    //Enable @Timed annotation aspects
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    // https://github.com/zalando/logbook#logstash-logback-encoder
    @Profile(ProfileNames.JSON_LOGS)
    @Bean
    public Sink logBookLogstashSink(ObjectMapper objectMapper) {
        return new LogstashLogbackSink(new JsonHttpLogFormatter(objectMapper));
    }
}
