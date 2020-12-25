package com.inventale.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inventale.project")
public class HelloWorldApplication {
    public static void main(String... args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
