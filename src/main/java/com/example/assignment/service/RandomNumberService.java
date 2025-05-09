package com.example.assignment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Service
public class RandomNumberService {

    @Autowired
    private final WebClient webClient;

    public RandomNumberService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://20.244.56.144/evaluation-service").build();
    }

    public List<Integer> fetchNumbers(String token,String type) {
        String req="/"+type;
        try {
            Map<String, List<Integer>> response = webClient.get()
                    .uri(req)
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .timeout(Duration.ofMillis(500))
                    .onErrorReturn(Map.of("numbers", List.of()))
                    .block();

            return (List<Integer>) response.get("numbers");
        } catch (Exception e) {
            return List.of();
        }
    }
}
