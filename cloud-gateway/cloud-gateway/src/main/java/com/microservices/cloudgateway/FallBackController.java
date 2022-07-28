package com.microservices.cloudgateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class FallBackController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String Base_URL = "http://localhost:8082/";

    private static final String USER = "users";

    @GetMapping
    @CircuitBreaker(name = "USER", fallbackMethod = "userFallBack")
    public String user(){
        return restTemplate.getForObject(Base_URL + "users/**", String.class);
    }
    
    public String userFallBack(Exception e){
        return "User is taking too long to respond,"+" please try again later.";
    }
}
