package com.inventale.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.inventale.project", exclude = { ContextInstanceDataAutoConfiguration.class })
public class HelloWorldApplication {
    public static void main(String... args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
