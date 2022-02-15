package com.example.craftsofttest.service;

import com.example.craftsofttest.model.Agent;
import com.example.craftsofttest.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgentService {
    AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent addAgent(Agent agent) throws Exception {
        Optional<Agent> agentByUserName = agentRepository.findAgentByUserName(agent.getUserName());
        if (agentByUserName.isPresent()) {
            throw new Exception("UserName already exists!");
        }
        return agentRepository.save(agent);
    }
}
