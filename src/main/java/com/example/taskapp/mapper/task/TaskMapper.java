package com.example.taskapp.mapper.task;

import com.example.taskapp.dto.task.TaskDto;
import com.example.taskapp.entity.task.Task;
import org.springframework.stereotype.Component;

/**
 * The class converts a date transfer object to an entity object and an entity object to a date transfer object.
 *
 */
@Component
public class TaskMapper {

    /**
     * Create a new TaskDto object, given the data provided.
     *
     * Converts given Task object to TaskDto object.
     *
     * @param task a task entity object
     * @return new converted object taskDto
     * @author PK
     */
    public TaskDto convertTaskToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .status(task.getStatus())
                .priority(task.getPriority())
                .description(task.getDescription())
                .build();
    }

    /**
     * Create a new Task object, given the data provided.
     *
     * Converts given Task object to TaskDto object.
     *
     * @param taskDto a task date transfer object
     * @return new converted object task
     * @author PK
     */
    public Task convertDtoToTask(TaskDto taskDto) {
        return Task.builder()
                .name(taskDto.getName())
                .status(taskDto.getStatus())
                .priority(taskDto.getPriority())
                .description(taskDto.getDescription())
                .build();
    }

    public Task updateTaskFromDto(Task task, TaskDto taskDto) {
        task.setId(taskDto.getId());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        task.setDescription(taskDto.getDescription());
        return task;
    }
}
