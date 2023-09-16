package com.example.demo.services;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SequenceServiceTest {
    private SequenceServiceInterface sequenceService = new SequenceService();
    @Test
    public void testCalculateSequence() {
        Map<Character, Integer> sequenceMap = sequenceService.calculateSequence("aaaaabcccc");
        assertEquals(3, sequenceMap.size());
        assertEquals(5, sequenceMap.get('a'));
        assertEquals(1, sequenceMap.get('b'));
        assertEquals(4, sequenceMap.get('c'));
    }

    @Test
    public void testCalculateSequence_EmptyString() {
        Map<Character, Integer> sequenceMap = sequenceService.calculateSequence("");
        assertEquals(0, sequenceMap.size());
    }
}