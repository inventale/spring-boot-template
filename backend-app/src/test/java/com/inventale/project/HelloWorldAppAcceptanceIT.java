package com.inventale.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.net.URL;

@SuppressWarnings("unused")
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// list of used spring profiles. Las profiles override properties from previous ones
@ActiveProfiles(profiles = {"test"})
public class HelloWorldAppAcceptanceIT {
    public static final String BASE_URL = "http://localhost:%s";

    // bind the above RANDOM_PORT
    @LocalServerPort
    protected transient int port;
    // to check Http endpoint
    @Autowired
    protected transient TestRestTemplate restTemplate;
    // to parse response
    @Autowired
    protected transient Gson gson;

    @Test
    public void request() {
        ResponseEntity<String> response = sendRequest();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        HelloWorldResult result = gson.fromJson(response.getBody(), HelloWorldResult.class);
        assertFalse(result.getMessage().isEmpty());
    }

    @SneakyThrows
    private ResponseEntity<String> sendRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> response = restTemplate.exchange(
                new URL(String.format(BASE_URL + "/hello", port)).toString(),
                HttpMethod.GET,
                entity,
                String.class
        );
        log.debug("Response: {}, {}", response.getStatusCode(), response.getBody());
        return response;
    }
}