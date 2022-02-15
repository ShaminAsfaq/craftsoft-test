package com.example.craftsofttest.controller;

import com.example.craftsofttest.service.TaskService;
import com.example.craftsofttest.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(HttpServletRequest httpServletRequest, @RequestBody Task task) {
        Task addedTask = taskService.addTask(task);
        return ResponseEntity.ok().body(addedTask);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateTask(HttpServletRequest httpServletRequest, @RequestBody Task task) throws Exception {
        boolean updatedTaskFlag = taskService.updateTask(task);
        return ResponseEntity.ok().body(updatedTaskFlag);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Task>> getAllTask(HttpServletRequest httpServletRequest) {
        List<Task> allTask = taskService.getAllTask();
        return ResponseEntity.ok().body(allTask);
    }

    @GetMapping("/get/{taskId}")
    public ResponseEntity<Task> getTaskById(HttpServletRequest httpServletRequest, @PathVariable int taskId) throws Exception {
        Task taskById = taskService.getTaskById(taskId);
        return ResponseEntity.ok().body(taskById);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Boolean> deleteTask(HttpServletRequest httpServletRequest, @PathVariable int taskId) throws Exception {
        boolean deletedTaskFlag = taskService.deleteTask(taskId);
        return ResponseEntity.ok().body(deletedTaskFlag);
    }

    @GetMapping("/set_assignee/{taskId}/{assigneeUserName}")
    public ResponseEntity<Boolean> setAssignee(HttpServletRequest httpServletRequest, @PathVariable int taskId,
                                               @PathVariable String assigneeUserName) throws Exception {
        boolean assigneeFlag = taskService.assignAssignee(taskId, assigneeUserName);
        return ResponseEntity.ok().body(assigneeFlag);
    }

    @GetMapping("/remove_assignee/{taskId}")
    public ResponseEntity<Boolean> removeAssignee(HttpServletRequest httpServletRequest, @PathVariable int taskId) throws Exception {
        boolean removeAssigneeFlag = taskService.removeAssignee(taskId);
        return ResponseEntity.ok().body(removeAssigneeFlag);
    }

    @GetMapping("/set_task_status/{taskId}/{taskStatusValue}")
    public ResponseEntity<Boolean> setTaskStatus(HttpServletRequest httpServletRequest, @PathVariable int taskId, @PathVariable String taskStatusValue) throws Exception {
        boolean updateTaskStatusFlag = taskService.updateTaskStatus(taskId, taskStatusValue);
        return ResponseEntity.ok().body(updateTaskStatusFlag);
    }

    @GetMapping("/filter_task_by_status/{taskStatusValue}")
    public ResponseEntity<List<Task>> filterTaskByStatus(HttpServletRequest httpServletRequest, @PathVariable String taskStatusValue) {
        List<Task> filterTaskByStatus = taskService.filterTaskByStatus(taskStatusValue);
        return ResponseEntity.ok().body(filterTaskByStatus);
    }

    @GetMapping("/filter_task_by_agent/{agentUserName}")
    public ResponseEntity<List<Task>> filterTaskByAgent(HttpServletRequest httpServletRequest, @PathVariable String agentUserName) {
        List<Task> filterTaskByStatus = taskService.filterTaskByAgent(agentUserName);
        return ResponseEntity.ok().body(filterTaskByStatus);
    }
}























