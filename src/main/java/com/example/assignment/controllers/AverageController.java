package com.example.assignment.controllers;


import com.example.assignment.service.AverageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/numbers")
public class AverageController {

    AverageService averageService;

    @Value("${token}")
    private String token;

    public AverageController(AverageService averageService){
        this.averageService=averageService;
    }


    @GetMapping("/{numberid}")
    public ResponseEntity<Map<String,Object>> getAverageOfNumbers(@PathVariable String numberid){
        Map<String,Object> result=averageService.calculateAverage(numberid,token);
        return ResponseEntity.ok(result);
    }
}
