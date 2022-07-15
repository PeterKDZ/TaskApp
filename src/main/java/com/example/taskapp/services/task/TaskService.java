package com.example.taskapp.services.task;

import com.example.taskapp.mappers.task.TaskMapper;
import com.example.taskapp.repositories.task.TaskRepository;
import com.example.taskapp.dtos.task.TaskDto;
import com.example.taskapp.entities.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.taskapp.mappers.task.TaskMapper.convertDtoToTask;
import static com.example.taskapp.mappers.task.TaskMapper.convertTaskToDto;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDto createTask(TaskDto taskDto) {
        Task task = convertDtoToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return convertTaskToDto(savedTask);
    }

}
