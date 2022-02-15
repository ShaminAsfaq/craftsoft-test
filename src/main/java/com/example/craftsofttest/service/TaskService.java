package com.example.craftsofttest.service;

import com.example.craftsofttest.model.Agent;
import com.example.craftsofttest.model.Task;
import com.example.craftsofttest.model.TaskStatus;
import com.example.craftsofttest.repository.AgentRepository;
import com.example.craftsofttest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    TaskRepository taskRepository;
    AgentRepository agentRepository;

    public TaskService(TaskRepository taskRepository, AgentRepository agentRepository) {
        this.taskRepository = taskRepository;
        this.agentRepository = agentRepository;
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(int taskId) throws Exception {
        Optional<Task> byId = taskRepository.findById(taskId);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new Exception("Task not found");
        }
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public boolean updateTask(Task task) throws Exception {
        Optional<Task> byId = taskRepository.findById(task.getId());
        if (byId.isPresent()) {
            task.setId(byId.get().getId());
            return true;
        } else {
            throw new Exception("Task not found");
        }
    }

    /**
     * Info:
     * Currently I am deleting from the DB. But, if there is any need of keeping the data intact but privately,
     * we might have to think about an alternate solution like using a boolean flag etc.
     *
     * @param taskId
     * @return
     */
    public boolean deleteTask(int taskId) throws Exception {
        Optional<Task> byId = taskRepository.findById(taskId);
        if (byId.isPresent()) {
            taskRepository.delete(byId.get());
            return true;
        } else {
            throw new Exception("Task not found");
        }
    }

    public boolean assignAssignee(int taskId, String userName) throws Exception {
        Optional<Task> byId = taskRepository.findById(taskId);
        Optional<Agent> byUserName = agentRepository.findAgentByUserName(userName);

        if (byId.isPresent() && byUserName.isPresent()) {
            byId.get().setAssignee(byUserName.get());
            taskRepository.save(byId.get());
            return true;
        }  else {
            throw new Exception("One or more items not found.");
        }
    }

    public boolean removeAssignee(int taskId) throws Exception {
        Optional<Task> byId = taskRepository.findById(taskId);
        if (byId.isPresent()) {
            byId.get().setAssignee(null);
            taskRepository.save(byId.get());
            return true;
        } else {
            throw new Exception("Task not found");
        }
    }

    //  --
    public List<Task> filterTaskByAgent(String agentUserName) {
        return taskRepository.findAllByAssignee_UserName(agentUserName);
    }

    public List<Task> filterTaskByStatus(String taskStatusValue) {
        TaskStatus taskStatus = TaskStatus.valueOfText(taskStatusValue);
        return taskRepository.findAllByTaskStatus(taskStatus);
    }

    public boolean updateTaskStatus(int taskId, String taskStatusValue) throws Exception {
        TaskStatus taskStatus = TaskStatus.valueOfText(taskStatusValue);
        Optional<Task> byId = taskRepository.findById(taskId);
        if (byId.isPresent()) {
            byId.get().setTaskStatus(taskStatus);
            return true;
        } else {
            throw new Exception("No such task found.");
        }
    }

    public List<Task> saveAll(List<Task> all) {
        return taskRepository.saveAll(all);
    }
}

























