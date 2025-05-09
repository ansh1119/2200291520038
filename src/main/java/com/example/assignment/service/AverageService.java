package com.example.assignment.service;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AverageService {

    RandomNumberService numberService;

    public AverageService(RandomNumberService numberService){
        this.numberService=numberService;
    }

    private final Deque<Integer> numberWindow = new ArrayDeque<>();
    private final Set<Integer> numberSet = new HashSet<>();
    private static final int WINDOW_SIZE = 10;

    public Map<String, Object> calculateAverage(String id, String token) {
        List<Integer> prevState = new ArrayList<>(numberWindow);

        // Fetch new numbers based on ID
        List<Integer> newNumbers = switch (id) {
            case "e" -> numberService.fetchNumbers(token,"even");
            case "p" -> numberService.fetchNumbers(token,"primes");
            case "f" -> numberService.fetchNumbers(token,"fibo");
            case "r" -> numberService.fetchNumbers(token,"rand");
            default -> List.of();
        };

//        List<Integer> newNumbers = numberService.fetchNumbers(token,id);


        //keeping the unique elements in set while maintaining order in the deque
        for (int num : newNumbers) {
            if (!numberSet.contains(num)) {
                if (numberWindow.size() == WINDOW_SIZE) {
                    int removed = numberWindow.removeFirst();
                    numberSet.remove(removed);
                }
                numberWindow.addLast(num);
                numberSet.add(num);
            }
        }


        double avg = numberWindow.stream().mapToInt(i -> i).average().orElse(0);

        return Map.of(
                "windowPrevState", prevState,
                "windowCurrState", new ArrayList<>(numberWindow),
                "numbers", newNumbers,
                "avg", String.format("%.2f", avg)
        );
    }
}
