package com.example.demo.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@NoArgsConstructor
public class SequenceService implements SequenceServiceInterface{
    @Override
    public Map<Character, Integer> calculateSequence(String input) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] chars = input.toCharArray();
        for (char c : chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        };
        return sortByValue(map);
    }
    private Map<Character, Integer> sortByValue(Map<Character, Integer> unsortMap) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
