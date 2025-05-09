package com.example.assignment.service;


import org.springframework.stereotype.Service;

@Service
public class AverageService {

    RandomNumberService numberService;

    public AverageService(RandomNumberService numberService){
        this.numberService=numberService;
    }


}
