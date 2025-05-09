package com.example.assignment.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("numbers")
public class AverageController {




    @GetMapping("/{numberid}")
    public ResponseEntity<Map<String,Object>> getAverageOfNumbers(@PathVariable String id){
        Map<String,Object>
    }
}
