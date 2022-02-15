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
    public void testAddAgent() throws Exception {
        Agent expected = new Agent();
        expected.setUserName("shamin");
        expected.setEmail("shamin.asfaq@gmail.com");

        Agent found = agentService.addAgent(expected);
        assertEquals(expected, found);
    }

    @Test
    @DisplayName("ADD_EXCEPTION")
    /**
     * This Test will fail if you run it. But if you run the entire class a test, it will pass. Because, it searches
     * for an Agent with userName "shamin" which is being created in the previous ADD test. This agent will not be in
     * the DB if you only run this test.
     */
    public void testAddAgentException() {
        Agent expected = new Agent();
        expected.setUserName("shamin");
        expected.setEmail("shamin.asfaq@gmail.com");

        Exception exception = assertThrows(Exception.class, () -> {
            agentService.addAgent(expected);
        });

        String expectedMessage = "UserName already exists!";
        String foundMessage = exception.getMessage();

        assertEquals(expectedMessage, foundMessage);

    }
}


















