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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Task other = (Task) obj;

        if (this.id != other.id) {
            return false;
        }

        if (this.name != null && other.name != null && !this.name.equals(other.name)) {
            return false;
        }

        if (this.description != null && other.description != null && !this.description.equals(other.description)) {
            return false;
        }

        if (this.taskGroup != null && other.taskGroup != null && !this.taskGroup.equals(other.taskGroup)) {
            return false;
        }

        if (this.taskStatus != null && other.taskStatus != null && !this.taskStatus.equals(other.taskStatus)) {
            return false;
        }

        if ((this.name == null && other.name != null) || (this.name != null && other.name == null)) {
            return false;
        }

        if ((this.description == null && other.description != null) || (this.description != null && other.description == null)) {
            return false;
        }

        if ((this.taskGroup == null && other.taskGroup != null) || (this.taskGroup != null && other.taskGroup == null)) {
            return false;
        }

        if ((this.taskStatus == null && other.taskStatus != null) || (this.taskStatus != null && other.taskStatus == null)) {
            return false;
        }

        if ((this.subTaskList == null && other.subTaskList != null) || (this.subTaskList != null && other.subTaskList == null)) {
            return false;
        }

        System.out.println(this);
        System.out.println(other);
        System.out.println("--");
        return true;
    }
}

