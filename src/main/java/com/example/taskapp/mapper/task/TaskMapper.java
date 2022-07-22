package com.example.taskapp.mapper.task;

import com.example.taskapp.dto.TaskDto;
import com.example.taskapp.entity.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto convertTaskToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .status(task.getStatus())
                .priority(task.getPriority())
                .description(task.getDescription())
                .build();
    }

    public Task convertDtoToTask(TaskDto taskDto) {
        return Task.builder()
                .name(taskDto.getName())
                .status(taskDto.getStatus())
                .priority(taskDto.getPriority())
                .description(taskDto.getDescription())
                .build();
    }
}
