package com.example.taskapp.mappers.task;

import com.example.taskapp.dtos.task.TaskDto;
import com.example.taskapp.entities.task.Task;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TaskMapper {


    public static TaskDto convertTaskToDto(Task task) {
        return TaskDto.builder().
                id(task.getId()).
                name(task.getName()).
                status(task.getStatus()).
                priority(task.getPriority()).
                description(task.getDescription()).
                build();
    }

    public static Task convertDtoToTask(TaskDto taskDto) {
        Task task = Task.builder().build();
        task.setName(taskDto.getName());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        task.setDescription(taskDto.getDescription());
        return task;
    }
}
