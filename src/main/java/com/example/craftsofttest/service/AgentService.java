package com.example.craftsofttest.service;

import com.example.craftsofttest.model.Agent;
import com.example.craftsofttest.repository.AgentRepository;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}
