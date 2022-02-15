package com.example.craftsofttest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Agent is someone we assign a task to")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Unique ID Autogenerated by H2 DB")
    private int id;
    @ApiModelProperty(notes = "UserName is considered Unique")
    private String userName;    //  userName will be unique.
    @ApiModelProperty(notes = "Email address of the agent")
    private String email;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Agent other = (Agent) obj;

        if (this.id != other.id) {
            return false;
        }

        if (!this.userName.equals(other.userName)) {
            return false;
        }

        return true;
    }
}
