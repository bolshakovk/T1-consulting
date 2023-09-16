package com.example.demo.controllers;

import com.example.demo.services.SequenceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
public class SequenceController {
    @Autowired
    SequenceServiceInterface sequenceService;
    @GetMapping("/sequence")
    public Map<Character, Integer> getSequenceByParam(@RequestParam String input){
        return sequenceService.calculateSequence(input);
    }
}
