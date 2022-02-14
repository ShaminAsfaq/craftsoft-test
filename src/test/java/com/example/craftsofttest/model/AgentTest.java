package com.example.craftsofttest.model;

import com.example.craftsofttest.repository.AgentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AgentTest {
    @Autowired
    AgentRepository agentRepository;

    @Test
    public void testAddAgent() {
        Agent agent = new Agent();
        agent.setUserName("shamin");
        agent.setEmail("shamin.asfaq@gmail.com");

        Agent save = agentRepository.save(agent);
        System.out.println(save);
    }

    @Test
    public void testGetAllAgent() {
        testAddAgent(); //  Insert first. Data is volatile in case of In-Memory DB.
        List<Agent> all = agentRepository.findAll();
        System.out.println("Total Found: " + all.size());
        all.forEach(System.out::println);
    }
}