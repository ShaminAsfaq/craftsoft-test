package com.example.craftsofttest.service;

import com.example.craftsofttest.model.Agent;
import com.example.craftsofttest.repository.AgentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AGENT TEST")
@SpringBootTest
public class AgentServiceTest {
    @Autowired
    AgentService agentService;

    @Test
    @DisplayName("ADD")
    public void testAddAgent() {
        Agent expected = new Agent();
        expected.setUserName("shamin");
        expected.setEmail("shamin.asfaq@gmail.com");

        Agent found = agentService.addAgent(expected);
        assertEquals(expected, found);
    }
}


















