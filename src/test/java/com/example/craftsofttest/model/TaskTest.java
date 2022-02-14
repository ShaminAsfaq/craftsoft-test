package com.example.craftsofttest.model;

import com.example.craftsofttest.repository.AgentRepository;
import com.example.craftsofttest.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskTest {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    AgentRepository agentRepository;

    @Test
    public void testAddTask() {
        //  Assignee Agent
        Agent agent = new Agent();
        agent.setUserName("shamin");
        agent.setEmail("shamin.asfaq@gmail.com");

        //  The Task
        Task task = new Task();
        task.setName("Technical Test");
        task.setDescription("If I can complete this technical test, I might get the job.");
        task.setTaskGroup(TaskGroup.SIMPLE);
        task.setTaskStatus(TaskStatus.WORKING_ON_IT);
        task.setAssignee(agent);
        task.setTimeSpentInMinutes(50);

        //  The Sub Tasks
        List<Task> subTaskList = new ArrayList<>();

        //  Sub Task 1
        Task subTask = new Task();
        subTask.setName("Sub Task 1");
        subTask.setDescription("Sub Task 1 Description");
        subTask.setTaskGroup(TaskGroup.CASUAL);
        subTaskList.add(subTask);

        //  Sub Task 2
        subTask = new Task();
        subTask.setName("Sub Task 2");
        subTask.setDescription("Sub Task 2 Description");
        subTask.setTaskGroup(TaskGroup.IMPORTANT);
        subTaskList.add(subTask);

        //  Sub Task 3
        subTask = new Task();
        subTask.setName("Sub Task 3");
        subTask.setDescription("Sub Task 3 Description");
        subTask.setTaskGroup(TaskGroup.CRITICAL);
        subTaskList.add(subTask);

        task.setSubTaskList(subTaskList);

        //  Saving in the DB
        Task save = taskRepository.save(task);

        assertEquals(task, save);
    }
}