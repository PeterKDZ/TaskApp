package com.example.taskapp.tasks;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Task {

    @Id
    private Long id;
    private String name;
    private Status status;
    private Priority priority;
    private String description;


    public static Task create(TaskDto taskDto) {
        Task task = new Task();
        task.name = taskDto.getName();
        task.status = taskDto.getStatus();
        task.priority = taskDto.getPriority();
        task.description = taskDto.getDescription();
        return task;
    }
    public TaskDto taskToDto(){
        return new TaskDto(id, name, status, priority, description);
    }

}
