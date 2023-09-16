package com.example.demo.controllers;

import com.example.demo.services.SequenceServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class SequenceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SequenceServiceInterface sequenceService;
    @Test
    public void testGetSequenceByParam() throws Exception {
        Map<Character, Integer> sequenceMap = new HashMap<>();
        sequenceMap.put('a', 5);
        sequenceMap.put('b', 1);
        sequenceMap.put('c', 4);
        when(sequenceService.calculateSequence("aaaaabcccc")).thenReturn(sequenceMap);

        this.mockMvc.perform(get("/sequence?input=aaaaabcccc"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"" +
                                "a\":5," +
                                "c\":4," +
                                "b\":1" +
                                "}"));
    }
    @Test
    public void testGetSequenceByParam_EmptyString() throws Exception {
        when(sequenceService.calculateSequence("")).thenReturn(new HashMap<>());

        this.mockMvc.perform(get("/sequence?input="))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }
}