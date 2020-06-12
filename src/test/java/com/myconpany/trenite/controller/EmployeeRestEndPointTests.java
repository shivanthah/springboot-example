package com.myconpany.trenite.controller;

import com.myconpany.trenite.entity.Employee;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeRestEndPointTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    @DisplayName("/employees rest api test ")
    void testMessage() throws JSONException {

        URI targetUrl= UriComponentsBuilder.fromUriString("/employees")
                .build()
                .encode()
                .toUri();

        ResponseEntity<String> response = this.restTemplate.getForEntity(targetUrl, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals("[{\"id\":1,\"name\":\"Bilbo Baggins\",\"role\":\"burglar\"},{\"id\":2,\"name\":\"Frodo Baggins\",\"role\":\"thief\"}]", response.getBody(), false);
    }

}
