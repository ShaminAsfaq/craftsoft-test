package com.example.craftsofttest.repository;

import com.example.craftsofttest.model.Task;
import com.example.craftsofttest.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByAssignee_UserName(String userName);
    List<Task> findAllByTaskStatus(TaskStatus taskStatus);
}
