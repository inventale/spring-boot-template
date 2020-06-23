package com.inventale.project.controller;

import com.inventale.project.HelloWorldResult;
import com.inventale.project.HelloWorldService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@Timed annotation is used for [prometheus] metrics gathering
@Timed
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/hello", method = { RequestMethod.GET })
    public HelloWorldResult helloWorld() {
        HelloWorldResult result = helloWorldService.getHelloWorld();
        log.debug("Hello world result: {}", result);
        return result;
    }
}
