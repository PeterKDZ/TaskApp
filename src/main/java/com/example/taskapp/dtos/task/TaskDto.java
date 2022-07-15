package com.example.taskapp.dtos.task;

import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TaskDto {
    private Long id;
    private String name;
    private Status status;
    private Priority priority;
    private String description;

}
