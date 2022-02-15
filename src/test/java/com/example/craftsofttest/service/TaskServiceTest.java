package com.example.craftsofttest.service;

import com.example.craftsofttest.model.Agent;
import com.example.craftsofttest.model.Task;
import com.example.craftsofttest.model.TaskGroup;
import com.example.craftsofttest.model.TaskStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TASK TEST")
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    TaskService taskService;

    @Test
    @DisplayName("ADD")
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
        Task save = taskService.addTask(task);

        assertEquals(task, save);
    }

    @Test
    @DisplayName("UPDATE_TRUE")
    public void testUpdateTaskTrue() throws Exception {
        Task task = new Task();
        taskService.addTask(task);

        task.setName("Task 1");
        boolean updateFlag = taskService.updateTask(task);
        assertTrue(updateFlag);
    }

    @Test
    @DisplayName("UPDATE_EXCEPTION")
    public void testUpdateTaskException() {
        Task task = new Task();
        Exception exception = assertThrows(Exception.class, () -> {
            taskService.updateTask(task);
        });

        String expectedMessage = "Task not found";
        String foundMessage = exception.getMessage();

        assertEquals(expectedMessage, foundMessage);
    }

    /**
     * There might be other better ways of Assertion when working with List of complex objects.
     * This specific solution might or might not work all the time.
     */
    @Test
    @DisplayName("GET_ALL")
    public void testGetAllTask() {
        List<Task> expectedList = new ArrayList<>();

        Task task1 = new Task();
        task1.setName("Task 1");

        Task task2 = new Task();
        task2.setName("Task 2");

        Task task3 = new Task();
        task3.setName("Task 3");

        expectedList.add(task1);
        expectedList.add(task2);
        expectedList.add(task3);

        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        List<Task> foundList = taskService.getAllTask();
        assertEquals(expectedList.containsAll(foundList), foundList.containsAll(expectedList));
    }

    @Test
    @DisplayName("GET_TASK")
    public void testGetTask() throws Exception {
        Task primaryTask = new Task();
        primaryTask.setName("Task 1");

        Task expectedTask = taskService.addTask(primaryTask);
        Task foundTask = taskService.getTaskById(expectedTask.getId());

        assertEquals(expectedTask.getId(), foundTask.getId());
    }

    @Test
    @DisplayName("DELETE_TASK")
    public void testDeleteTask() throws Exception {
        Task primaryTask = new Task();
        primaryTask.setName("Task 1");
        Task expectedTask = taskService.addTask(primaryTask);

        boolean deleteFlag = taskService.deleteTask(expectedTask.getId());
        assertTrue(deleteFlag);
    }

    @Test
    @DisplayName("DELETE_TASK_EXCEPTION")
    public void testDeleteTaskException() {
        Exception exception = assertThrows(Exception.class, () -> {
            taskService.deleteTask(100);
        });
        String expectedMessage = "Task not found";
        String foundMessage = exception.getMessage();

        assertEquals(expectedMessage, foundMessage);
    }

    @Test
    @DisplayName("GET_TASK_EXCEPTION")
    public void testGetTaskException() {
        Exception exception = assertThrows(Exception.class, () -> {
            taskService.getTaskById(100);
        });
        String expectedMessage = "Task not found";
        String foundMessage = exception.getMessage();

        assertEquals(expectedMessage, foundMessage);
    }



}























