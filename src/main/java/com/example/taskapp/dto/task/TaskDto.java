package com.example.taskapp.dto.task;

import com.example.taskapp.enums.task.Priority;
import com.example.taskapp.enums.task.Status;
import com.example.taskapp.validator.StatusValidator;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The class represents a task date transfer object.
 *
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @StatusValidator(statuses = {Status.TO_DO, Status.IN_PROGRESS, Status.DONE})
    private Status status;
    private Priority priority;
    private String description;

}
