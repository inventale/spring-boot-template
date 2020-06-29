package com.inventale.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        HelloWorldMessageProvider helloWorldMessageProvider = mock(HelloWorldMessageProvider.class);
        when(helloWorldMessageProvider.getMessage()).thenReturn(target);

        HelloWorldService helloWorldService = new HelloWorldService(helloWorldMessageProvider);
        HelloWorldResult actualResult = helloWorldService.getHelloWorld();
        assertEquals(new HelloWorldResult(target), actualResult);
    }
}