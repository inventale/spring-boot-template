package com.inventale.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HelloWorldServiceTest {
    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("test1"),
                Arguments.of("test2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void testHelloWorldService(String target) {
        HelloWorldService helloWorldService = new HelloWorldService(target);
        HelloWorldResult actualResult = helloWorldService.getHelloWorld();
        assertEquals(new HelloWorldResult("Hello world, " + target), actualResult);
    }
}