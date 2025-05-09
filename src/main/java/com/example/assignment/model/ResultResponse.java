package com.example.assignment.model;


import lombok.Data;

import java.util.List;

@Data
public class ResultResponse {

    List<Integer> windowPrevState;
    List<Integer> windowCurrState;
    List<Integer> numbers;
    double avg;


    public ResultResponse(List<Integer> windowPrevState, List<Integer> windowCurrState, List<Integer> numbers, double avg) {
        this.windowPrevState = windowPrevState;
        this.windowCurrState = windowCurrState;
        this.numbers = numbers;
        this.avg = avg;
    }
}
