package com.example.craftsofttest.controller;

import com.example.craftsofttest.model.Agent;
import com.example.craftsofttest.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/agent")
public class AgentController {
    AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Agent> addAgent(HttpServletRequest httpServletRequest, @RequestBody Agent agent) throws Exception {
        Agent addAgent = agentService.addAgent(agent);
        return ResponseEntity.ok().body(addAgent);
    }
}
