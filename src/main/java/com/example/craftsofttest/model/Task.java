package com.example.craftsofttest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private TaskGroup taskGroup;
    private TaskStatus taskStatus;
    @OneToOne (cascade=CascadeType.ALL)
    private Agent assignee;
    private int timeSpentInMinutes;
    @OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Task> subTaskList;
}

