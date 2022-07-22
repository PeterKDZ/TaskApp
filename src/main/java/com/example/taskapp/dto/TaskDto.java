package com.example.taskapp.dto;

import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class TaskDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private Status status;
    private Priority priority;
    private String description;

}
