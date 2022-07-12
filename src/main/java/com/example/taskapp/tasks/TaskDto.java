package com.example.taskapp.tasks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String name;
    private Status status;
    private Priority priority;
    private String description;

    public TaskDto(Long id, String name, Status status, Priority priority, String description) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.priority = priority;
        this.description = description;
    }
}
